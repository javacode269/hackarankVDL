package DesignPattern.AdapterDesignPattern.BirdToyDemo.Adapter;

import DesignPattern.AdapterDesignPattern.BirdToyDemo.Adaptee.ToyDuck;
import DesignPattern.AdapterDesignPattern.BirdToyDemo.Target.Bird;

public class BirdAdapter implements ToyDuck
{
    // You need to implement the interface your
    // client expects to use.
    Bird bird;
    public BirdAdapter(Bird bird)
    {
        // we need reference to the object we
        // are adapting
        this.bird = bird;
    }

    public void squeak()
    {
        // translate the methods appropriately
        bird.makeSound();
    }
}