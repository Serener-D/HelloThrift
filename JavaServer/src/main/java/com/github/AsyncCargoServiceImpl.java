package com.github;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

public class AsyncCargoServiceImpl implements CargoService.AsyncIface {

    private ServerCargoService serverCargoService = new ServerCargoService();

    @Override
    public void ping(AsyncMethodCallback<String> resultHandler) {
        resultHandler.onComplete(serverCargoService.ping());
    }

    @Override
    public void calculateShippingCost(Cargo cargo, AsyncMethodCallback<String> resultHandler) throws TException {
        resultHandler.onComplete(serverCargoService.calculateShippingCost(cargo));
    }

    @Override
    public void sendCargo(Cargo cargo, AsyncMethodCallback<Integer> resultHandler) throws TException {
        resultHandler.onComplete(serverCargoService.sendCargo(cargo));
    }

    @Override
    public void checkStatusByHash(int hash, AsyncMethodCallback<DeliveryStatus> resultHandler) {
        resultHandler.onComplete(serverCargoService.checkStatusByHash(hash));
    }

}
