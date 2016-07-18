package com.esmartboard.server;

import com.esmartboard.service.remote.SmartBoardService;
import com.esmartboard.service.remote.SmartBoardServiceImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Administrator on 2016/7/18 0018.
 */
public class Server {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "SmartBoardService";
            SmartBoardService engine = new SmartBoardServiceImpl();
            SmartBoardService stub =
                    (SmartBoardService) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("SmartBoardService bound");
        } catch (Exception e) {
            System.err.println("SmartBoardService exception:");
            e.printStackTrace();
        }
    }
}
