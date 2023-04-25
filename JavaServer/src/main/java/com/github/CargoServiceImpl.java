package com.github;

public class CargoServiceImpl implements CargoService.Iface {

    @Override
    public String ping() {
        return "Pong";
    }

    @Override
    public String calculateShippingCost(Cargo cargo) throws EmptyCargoException, CargoWeigtExceededException {
        return null;
    }

    // todo make it idempotent
    @Override
    public long sendCargo(Cargo cargo) throws EmptyCargoException, CargoWeigtExceededException {
        return 0;
    }

    @Override
    public DeliveryStatus checkStatusById(long id) {
        return null;
    }

}
