package principle.interfacesegregation.document;



interface IEatAnimal {

    void eat();
}
interface IFlyAnimal {
    void fly();
}
interface ISwimAnimal {

    void swim();
}
class Dog implements ISwimAnimal, IEatAnimal {
    @Override
    public void eat() {

    }

    @Override
    public void swim() {

    }
}
class Bird implements IFlyAnimal, IEatAnimal {
    @Override
    public void eat() {

    }

    @Override
    public void fly() {

    }
}


public class Main {
}
