package com.github;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static com.github.DeliveryStatus.DELIVERED;

@Slf4j
public class ClientCargoService {

    private final CargoService.Client client;
    private final Random random;
    private long productCounter;
    private final ConcurrentHashMap<Integer, DeliveryStatus> sentCargoCache;

    public ClientCargoService(CargoService.Client client) {
        this.client = client;
        this.random = new Random();
        this.sentCargoCache = new ConcurrentHashMap<>();
    }

    public void init() throws InterruptedException {
        startCheckStatusLoop();
        while (true) {
            Cargo cargo = createCargo();
            try {
                BigDecimal cost = checkShippingCost(cargo);
                if (cost.compareTo(BigDecimal.valueOf(10000)) < 0) {
                    int hash = client.sendCargo(cargo);
                    sentCargoCache.put(hash, DeliveryStatus.CREATED);
                    log.info("Cargo sent, hash={}", hash);
                } else {
                    log.info("Shipping cost={} is too high", cost);
                }
            } catch (EmptyCargoException emptyCargoException) {
                log.error("Empty cargo was sent");
            } catch (CargoWeigtExceededException cargoWeigtExceededException) {
                log.error("Too heavy cargo was sent");
            } catch (TException tException) {
                log.error("Something bad happened", tException);
            }
            Thread.sleep(5000);
        }
    }

    private void startCheckStatusLoop() {
        Runnable runnable = () -> {
            while (true) {
                Set<Integer> hashes = sentCargoCache.keySet();
                for (Integer hash : hashes) {
                    try {
                        DeliveryStatus status = client.checkStatusByHash(hash);
                        if (status == DELIVERED) {
                            log.info("Cargo={} Delivered", hash);
                            sentCargoCache.remove(hash);
                        } else {
                            log.info("Current status={} for cargo={}", status, hash);
                            sentCargoCache.put(hash, status);
                        }
                    } catch (TException tException) {
                        log.error("Something bad happened", tException);
                    }
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private BigDecimal checkShippingCost(Cargo cargo) throws TException {
        String shippingCost = client.calculateShippingCost(cargo);
        return BigDecimal.valueOf(Double.parseDouble(shippingCost)).setScale(2, RoundingMode.CEILING);
    }

    private Cargo createCargo() {
        List<Product> productList = createProductList();
        DeliveryType deliveryType = DeliveryType.findByValue(random.nextInt(4));
        boolean isUrgent = random.nextInt(7) == 0;
        return new Cargo(productList, isUrgent, deliveryType);
    }

    private List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();
        int productsNumber = random.nextInt(8);
        for (int i = 0; i < productsNumber; i++) {
            double productWeight = random.nextDouble(1200d);
            double trimmedProductWeight = ((int) (productWeight * 100.0)) / 100.0;
            productList.add(new Product(trimmedProductWeight, "product#" + productCounter++));
        }
        return productList;
    }

}
