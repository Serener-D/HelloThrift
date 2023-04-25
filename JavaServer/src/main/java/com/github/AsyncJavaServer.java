package com.github;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

public class AsyncJavaServer {

    public static void main(String[] args) throws TTransportException {
        TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(8080);
        TNonblockingServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport)
                .processor(new CargoService.AsyncProcessor<>(new AsyncCargoServiceImpl())));

        System.out.print("Starting the server... ");
        server.serve();
    }

}
