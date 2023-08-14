package DesignPattern.AdapterDesignPattern.BirdToyDemo.Adaptee;

public class PlasticToyDuck implements ToyDuck
{
    public PlasticToyDuck() {
    }

    public void squeak()
    {
        System.out.println("Squeak");
    }
}



