package Animal;

public class Horse extends Mammal {
    private static int count = 0;

    public Horse(String name, int age) {
        super(name, age);
        setLegNumber(4);
        setPregnancyPerYear(1);
        setNumberOfOffsprings(1);
        count++;
    }

    public void sayGreeting() {
        System.out.println("I will work harder!");
    }

    public static int getCount() {
        return count;
    }

    public static void decrementCount() {
        count--;
    }

	public static void incrementCount() {
		count++;
	}
}
