package DesignPattern.FactoryMethodDesignPattern;

import java.util.Random;

public class BasicAnimalFactory implements IFactoryMethod {
    private BasicAnimalFactory() {
    }
    public IAnimal genAnimal(){
        Random rand = new Random();
        int randInt = rand.nextInt(3);

        switch (randInt){
            case 0:
                return  new Cat();
            case 1:
                return  new Dog();
            case 2:
                return  new Duck();
            default:
                throw new IllegalArgumentException("This animal type is unsupported");
        }
    }

}
