package com.github;

import lombok.extern.slf4j.Slf4j;

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

@Slf4j
public class CargoServiceImpl implements CargoService.Iface {

    private final ConcurrentHashMap<Integer, DeliveryStatus> sentCargoCache;
    private final LinkedBlockingDeque<Integer> createdCargoQueue;
    private final LinkedBlockingDeque<Integer> inProgressCargoQueue;
    private final Map<DeliveryType, Double> deliveryTypeCostMultiplier;

    private static final String CARGO_LOG = "Cargo with hash={} has status={}";

    {
        this.sentCargoCache = new ConcurrentHashMap<>();
        this.createdCargoQueue = new LinkedBlockingDeque<>();
        this.inProgressCargoQueue = new LinkedBlockingDeque<>();
        this.deliveryTypeCostMultiplier = Map.of(BY_SEA, 1d, BY_TRAIN, 1.2d, BY_TRUCK, 1.5d, BY_PLAIN, 2d);
        this.startLoop();
    }

    @Override
    public String ping() {
        return "Pong";
    }

    @Override
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

    @Override
    public int sendCargo(Cargo cargo) throws EmptyCargoException, CargoWeigtExceededException {
        validateCargo(cargo);
        int hash = cargo.hashCode();
        sentCargoCache.putIfAbsent(hash, CREATED);
        createdCargoQueue.add(hash);
        log.info(CARGO_LOG, hash, CREATED);
        return hash;
    }

    @Override
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
                if (hash1 != null) {
                    log.info(CARGO_LOG, hash1, DELIVERED);
                    sentCargoCache.put(hash1, DELIVERED);
                }
                Integer hash2 = createdCargoQueue.poll();
                if (hash2 != null) {
                    log.info(CARGO_LOG, hash2, IN_PROGRESS);
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
