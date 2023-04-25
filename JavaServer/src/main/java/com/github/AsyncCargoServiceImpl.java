package com.github;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

public class AsyncCargoServiceImpl implements CargoService.AsyncIface {

    @Override
    public void ping(AsyncMethodCallback<String> resultHandler) throws TException {
        resultHandler.onComplete("Pong");
    }

    @Override
    public void calculateShippingCost(Cargo cargo, AsyncMethodCallback<String> resultHandler) throws TException {

    }

    @Override
    public void sendCargo(Cargo cargo, AsyncMethodCallback<Long> resultHandler) throws TException {

    }

    @Override
    public void checkStatusById(long id, AsyncMethodCallback<DeliveryStatus> resultHandler) throws TException {

    }

}
