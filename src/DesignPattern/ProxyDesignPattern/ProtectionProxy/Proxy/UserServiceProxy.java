package DesignPattern.ProxyDesignPattern.ProtectionProxy.Proxy;

import DesignPattern.ProxyDesignPattern.ProtectionProxy.RealSubject.RealUserService;
import DesignPattern.ProxyDesignPattern.ProtectionProxy.Subject.UserService;

public class UserServiceProxy implements UserService {

    private String role;
    private UserService userService;

    public UserServiceProxy(String name, String role) {
        this.role = role;
        userService = new RealUserService(name);
    }

    @Override
    public void load() {
        userService.load();
    }

    @Override
    public void insert() {
        if (isAdmin()) {
            userService.insert();
        } else {
            throw new IllegalAccessError("Access denied");
        }
    }

    private boolean isAdmin() {
        return "admin".equalsIgnoreCase(this.role);
    }
}