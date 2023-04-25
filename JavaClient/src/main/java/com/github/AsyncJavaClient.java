package com.github;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;

import java.io.IOException;

public class AsyncJavaClient {

    public static void main(String[] args) throws InterruptedException, TException, IOException {
        TNonblockingTransport transport = null;

        transport = new TNonblockingSocket("localhost", 8080);

        TAsyncClientManager clientManager = null;

        clientManager = new TAsyncClientManager();

        TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();
        CargoService.AsyncClient client = new CargoService.AsyncClient(protocolFactory, clientManager, transport);

        client.ping(new PingCallback());
        Thread.sleep(500);
    }

    private static class PingCallback implements AsyncMethodCallback<String> {

        @Override
        public void onComplete(String s) {
            System.out.println(s);
        }

        @Override
        public void onError(Exception e) {
            System.out.println(e);
        }
    }

}
