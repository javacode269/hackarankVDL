package DesignPattern.ProxyDesignPattern.RemoteProxy.RMI.InterFaceRMI;

// Implementing the remote interface
public class SayHello implements SaySomeThing {

    // Implementing the interface method
    public void printMsg() {
        System.out.println("This is an example RMI program");
    }
}