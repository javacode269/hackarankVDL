package DesignPattern.ProxyDesignPattern.RemoteProxy.RMI.InterFaceRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating Remote interface for our application
public interface SaySomeThing extends Remote {
    void printMsg() throws RemoteException;
}