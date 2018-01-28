package com.itcast.basic.distributedmethodinvocation.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by qfl on 16/5/22.
 */
public interface Actions extends Remote {
    void sysHello(String name) throws RemoteException;
}
