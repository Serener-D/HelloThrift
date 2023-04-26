package com.github;

public class CargoServiceImpl implements CargoService.Iface {

    private final ServerCargoService serverCargoService = new ServerCargoService();

    @Override
    public String ping() {
        return serverCargoService.ping();
    }

    @Override
    public String calculateShippingCost(Cargo cargo) throws EmptyCargoException, CargoWeigtExceededException {
        return serverCargoService.calculateShippingCost(cargo);
    }

    @Override
    public int sendCargo(Cargo cargo) throws EmptyCargoException, CargoWeigtExceededException {
        return serverCargoService.sendCargo(cargo);
    }

    @Override
    public DeliveryStatus checkStatusByHash(int hash) {
        return serverCargoService.checkStatusByHash(hash);
    }

}
