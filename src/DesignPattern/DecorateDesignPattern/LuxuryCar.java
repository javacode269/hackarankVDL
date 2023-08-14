package DesignPattern.DecorateDesignPattern;

public class LuxuryCar extends CarDecorator {

    public LuxuryCar(ICar c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}