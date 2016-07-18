package com.esmartboard.client;

import com.esmartboard.service.remote.SmartBoardService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Administrator on 2016/7/18 0018.
 */
public class Client {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "SmartBoardService";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            SmartBoardService smartBoardService = (SmartBoardService) registry.lookup(name);

        } catch (Exception e) {
            System.err.println("SmartBoardService exception:");
            e.printStackTrace();
        }
    }
}
