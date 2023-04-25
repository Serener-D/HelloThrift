package com.github;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class JavaClient {

    public static void main(String[] args) throws TException, InterruptedException {
        TTransport transport = new TSocket("localhost", 8080);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        CargoService.Client client = new CargoService.Client(protocol);

        String result = client.ping();

        System.out.println(result);

        ClientCargoService clientCargoService = new ClientCargoService(client);

        transport.close();
    }

}