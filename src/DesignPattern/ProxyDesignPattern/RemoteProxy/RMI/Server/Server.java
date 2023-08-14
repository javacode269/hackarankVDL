package DesignPattern.ProxyDesignPattern.RemoteProxy.RMI.Server;

import DesignPattern.ProxyDesignPattern.RemoteProxy.RMI.InterFaceRMI.SaySomeThing;
import DesignPattern.ProxyDesignPattern.RemoteProxy.RMI.InterFaceRMI.SayHello;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends SayHello {
    public Server() {}
    public static void main(String args[]) {
        try {
            // Instantiating the implementation class
            SayHello obj = new SayHello();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            SaySomeThing stub = (SaySomeThing) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            System.out.println(java.net.InetAddress.getLocalHost().getHostAddress());

            registry.bind("SaySomeThing", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}