package com.github;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

@Slf4j
public class ServerMain {

    public static void main(String[] args) throws TTransportException {
        TServerTransport serverTransport = new TServerSocket(8080);
        TServer server = new TSimpleServer(new TServer.Args(serverTransport)
                .processor(new CargoService.Processor<>(new CargoServiceImpl())));

        log.info("Starting the server... ");
        server.serve();
    }

}