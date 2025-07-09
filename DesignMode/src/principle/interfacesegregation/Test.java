package principle.interfacesegregation;




















interface IAnimal {

    void eat();
    void fly();
    void swim();
}
class Dog implements IAnimal {
    @Override
    public void eat() {

    }

    @Override
    public void fly() {
    }

    @Override
    public void swim() {
    }
}
class Bird implements IAnimal {
    @Override
    public void eat() {
    }

    @Override
    public void fly() {
    }

    @Override
    public void swim() {

    }
}

public class Test {
}
