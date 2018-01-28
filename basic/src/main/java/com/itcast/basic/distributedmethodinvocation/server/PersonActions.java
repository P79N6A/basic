package com.itcast.basic.distributedmethodinvocation.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by qfl on 16/5/22.
 */
public class PersonActions extends UnicastRemoteObject implements Actions {
    public PersonActions() throws RemoteException {

    }

    @Override
    public void sysHello(String name) throws RemoteException {
        System.out.println("hello world " + name);
    }
}
