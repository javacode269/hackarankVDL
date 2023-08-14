package DesignPattern.FactoryMethodDesignPattern;

public interface IFactoryMethod {

    public IAnimal genAnimal();

}

//
//    public static void main(String[] args) {
//        IAnimal animal = AnimalFactory.genAnimal(animalType.DOG);
//        System.out.println("Type of animal is + " + animal.getNameType());
//    }
