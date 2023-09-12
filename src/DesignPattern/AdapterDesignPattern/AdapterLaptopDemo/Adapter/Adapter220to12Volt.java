package DesignPattern.AdapterDesignPattern.AdapterLaptopDemo.Adapter;

import DesignPattern.AdapterDesignPattern.AdapterLaptopDemo.Adaptee.Vold12;
import DesignPattern.AdapterDesignPattern.AdapterLaptopDemo.Target.Volt220;

public class Adapter220to12Volt implements Volt220 {
    private Vold12 vold12;

    public Adapter220to12Volt(Vold12 vold12) {
        this.vold12 = vold12;
    }

    public void  translator(){

        System.out.println("Chuyen nguon dao vao 220 volt sang nguon 12 vold");
    }

    @Override
    public void sendElectricFlow() {
        System.out.println("nhan nguon dau vao 220 vold");
        translator();
        System.out.println("gui nguon dau ra 12 vold");
        vold12.receive();
    }
}
