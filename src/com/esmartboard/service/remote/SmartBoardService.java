package com.esmartboard.service.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface SmartBoardService extends Remote {
    public void sendScreenCaptureToClient(String msg) throws RemoteException;
}
