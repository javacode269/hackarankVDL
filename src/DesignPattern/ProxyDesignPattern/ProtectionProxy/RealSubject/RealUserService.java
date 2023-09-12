package DesignPattern.ProxyDesignPattern.ProtectionProxy.RealSubject;


import DesignPattern.ProxyDesignPattern.ProtectionProxy.Subject.UserService;

public class RealUserService implements UserService {

    private String name;

    public RealUserService(String name) {
        this.name = name;
    }

    @Override
    public void load() {
        System.out.println(name + " loaded");
    }

    @Override
    public void insert() {
        System.out.println(name + " inserted");
    }

}
