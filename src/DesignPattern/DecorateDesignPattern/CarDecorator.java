package DesignPattern.DecorateDesignPattern;

public class CarDecorator implements ICar {

    protected ICar car;

    public CarDecorator(ICar c){
        this.car=c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }

}