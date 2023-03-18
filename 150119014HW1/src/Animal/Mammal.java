package Animal;

public class Mammal extends Animal {
    public Mammal(String name, int age) {
        super(name, age);
    }

    public void walk() {
        System.out.println("My name is "+ getName() +" I can walk to the faraway lands!");
    }

    @Override
    public void reproduce() {
        System.out.println("My name is "+ getName() +" I give birth!");
    }

    public void herbivore() {
        System.out.println("My name is "+ getName() +" I eat plants only!");
    }
}

