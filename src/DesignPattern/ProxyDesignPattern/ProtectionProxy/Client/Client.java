package DesignPattern.ProxyDesignPattern.ProtectionProxy.Client;

import DesignPattern.ProxyDesignPattern.ProtectionProxy.Proxy.UserServiceProxy;
import DesignPattern.ProxyDesignPattern.ProtectionProxy.Subject.UserService;

public class Client {
    public static void main(String[] args) {
        UserService admin = new UserServiceProxy("gpcoder", "admin");
        admin.load();
        admin.insert();

        UserService customer = new UserServiceProxy("customer", "guest");
        customer.load();
        customer.insert();
    }
}