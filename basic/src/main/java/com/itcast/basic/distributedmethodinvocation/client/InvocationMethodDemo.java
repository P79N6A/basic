package com.itcast.basic.distributedmethodinvocation.client;

import com.itcast.basic.distributedmethodinvocation.server.Actions;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by qfl on 16/5/22.
 */
public class InvocationMethodDemo {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Actions actions = (Actions) Naming.lookup("rmi://localhost:8888/person_actions");
        actions.sysHello("lily");
    }
}
