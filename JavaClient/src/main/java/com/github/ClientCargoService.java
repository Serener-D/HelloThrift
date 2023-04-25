package com.github;

import org.apache.thrift.TException;

import java.math.BigDecimal;
import java.util.List;

public class ClientCargoService {

    private CargoService.Client client;

    public ClientCargoService(CargoService.Client client) throws TException, InterruptedException {
        this.client = client;

        List<Product> productList = List.of(new Product(1000, "toyBears"), new Product(2000, "videoGames"));
        Cargo cargo = new Cargo(productList, false, DeliveryType.BY_TRUCK);
        String shippingCost = client.calculateShippingCost(cargo);
        BigDecimal bigDecimalShippingCost = BigDecimal.valueOf(Double.parseDouble(shippingCost));
        if (bigDecimalShippingCost.compareTo(BigDecimal.valueOf(1000)) > 0) {
            int hash = client.sendCargo(cargo);
            DeliveryStatus status = client.checkStatusByHash(hash);
            System.out.println(status);
            Thread.sleep(1200);
            System.out.println(client.checkStatusByHash(hash));
            Thread.sleep(1200);
            System.out.println(client.checkStatusByHash(hash));
            Thread.sleep(1200);
            System.out.println(client.checkStatusByHash(hash));
        }

    }


}
