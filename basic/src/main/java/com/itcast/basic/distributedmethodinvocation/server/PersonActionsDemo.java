package com.itcast.basic.distributedmethodinvocation.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by qfl on 16/5/22.
 */
public class PersonActionsDemo {
    public static void main(String[] args) throws Exception {
        Actions personActions = new PersonActions();
        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://localhost:8888/person_actions", personActions);
    }
}
