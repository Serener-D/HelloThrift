package com.github;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

import static com.github.DeliveryStatus.CREATED;
import static com.github.DeliveryStatus.DELIVERED;
import static com.github.DeliveryStatus.IN_PROGRESS;
import static com.github.DeliveryStatus.NOT_FOUND;
import static com.github.DeliveryType.BY_PLAIN;
import static com.github.DeliveryType.BY_SEA;
import static com.github.DeliveryType.BY_TRAIN;
import static com.github.DeliveryType.BY_TRUCK;
import static com.github.helloConstants.CARGO_WEIGHT_LIMIT;

public class ServerCargoService {

    private final ConcurrentHashMap<Integer, DeliveryStatus> sentCargoCache = new ConcurrentHashMap<>();

    private final LinkedBlockingDeque<Integer> createdCargoQueue = new LinkedBlockingDeque<>();
    private final LinkedBlockingDeque<Integer> inProgressCargoQueue = new LinkedBlockingDeque<>();

    private final Map<DeliveryType, Double> deliveryTypeCostMultiplier =
            Map.of(BY_SEA, 1d, BY_TRAIN, 1.2d, BY_TRUCK, 1.5d, BY_PLAIN, 2d);

    {
        this.startLoop();
    }

    public String ping() {
        return "Pong";
    }

    public String calculateShippingCost(Cargo cargo) throws EmptyCargoException, CargoWeigtExceededException {
        validateCargo(cargo);

        Double cargoWeight = cargo.getProducts().stream().map(Product::getWeight).reduce(0d, Double::sum);
        BigDecimal shippingCost = BigDecimal.valueOf(cargoWeight);
        shippingCost = shippingCost.multiply(BigDecimal.valueOf(deliveryTypeCostMultiplier.get(cargo.deliveryType)));
        if (cargo.isUrgent) {
            shippingCost = shippingCost.multiply(BigDecimal.valueOf(2));
        }

        return shippingCost.toString();
    }

    public int sendCargo(Cargo cargo) throws EmptyCargoException, CargoWeigtExceededException {
        validateCargo(cargo);
        int hash = cargo.hashCode();
        sentCargoCache.putIfAbsent(hash, CREATED);
        createdCargoQueue.add(hash);
        return hash;
    }

    public DeliveryStatus checkStatusByHash(int hash) {
        DeliveryStatus status = sentCargoCache.getOrDefault(hash, NOT_FOUND);
        if (status == DELIVERED) {
            sentCargoCache.remove(hash);
        }
        return status;
    }

    public void startLoop() {
        Runnable runnable = () -> {
            while (true) {
                Integer hash1 = inProgressCargoQueue.poll();
                Optional.ofNullable(hash1).ifPresent(hash -> sentCargoCache.put(hash, DELIVERED));
                Integer hash2 = createdCargoQueue.poll();
                if (hash2 != null) {
                    sentCargoCache.put(hash2, IN_PROGRESS);
                    inProgressCargoQueue.add(hash2);

                }
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void validateCargo(Cargo cargo) throws EmptyCargoException, CargoWeigtExceededException {
        if (cargo.getProducts().isEmpty()) {
            throw new EmptyCargoException();
        }
        Double cargoWeight = cargo.getProducts().stream().map(Product::getWeight).reduce(0d, Double::sum);
        if (cargoWeight.compareTo(CARGO_WEIGHT_LIMIT) > 0) {
            throw new CargoWeigtExceededException();
        }
    }

}
