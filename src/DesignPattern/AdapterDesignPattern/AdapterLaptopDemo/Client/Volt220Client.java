package DesignPattern.AdapterDesignPattern.AdapterLaptopDemo.Client;

import DesignPattern.AdapterDesignPattern.AdapterLaptopDemo.Adaptee.Vold12;
import DesignPattern.AdapterDesignPattern.AdapterLaptopDemo.Adapter.Adapter220to12Volt;
import DesignPattern.AdapterDesignPattern.AdapterLaptopDemo.Target.Volt220;

public class Volt220Client {
    public static void main(String[] args) {
        Volt220 volt220adapter12v = new Adapter220to12Volt(new Vold12());
        volt220adapter12v.sendElectricFlow();
    }
}
