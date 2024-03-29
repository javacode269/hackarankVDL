package DesignPattern.AdapterDesignPattern.BirdToyDemo.Client;

import DesignPattern.AdapterDesignPattern.BirdToyDemo.Adaptee.PlasticToyDuck;
import DesignPattern.AdapterDesignPattern.BirdToyDemo.Adaptee.ToyDuck;
import DesignPattern.AdapterDesignPattern.BirdToyDemo.Adapter.BirdAdapter;
import DesignPattern.AdapterDesignPattern.BirdToyDemo.Target.Sparrow;

public class Client {

    public static void main(String args[])
    {
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        // Wrap a bird in a birdAdapter so that it
        // behaves like toy duck
        ToyDuck birdAdapter = new BirdAdapter(sparrow);

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("ToyDuck...");
        toyDuck.squeak();

        // toy duck behaving like a bird
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();
    }
}
