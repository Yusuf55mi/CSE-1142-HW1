package Animal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnimalFarm {
    private final ArrayList<Animal> animalList;
    private final ArrayList<String> animalNames;
    private final int CAPACITY;
    private int numberOfAnimals;

    public AnimalFarm(int capacity) {
        this.CAPACITY = capacity;
        this.numberOfAnimals = 0;
        this.animalList = new ArrayList<Animal>(capacity);
        this.animalNames = new ArrayList<String>(capacity);
    }

    public int getNumberOfAnimals() {
        return this.numberOfAnimals;
    }

    public boolean addAnimal(Animal animal) throws IllegalNameException {
        if (this.numberOfAnimals < this.CAPACITY && !this.animalNames.contains(animal.getName())) {
            this.animalList.add(animal);
            this.animalNames.add(animal.getName());
            this.numberOfAnimals++;

            if (animal instanceof Chicken) {
                Chicken.incrementCount();
            } else if (animal instanceof Donkey) {
                Donkey.incrementCount();
            } else if (animal instanceof Horse) {
                Horse.incrementCount();
            } else if (animal instanceof Pig) {
                Pig.incrementCount();
            } else if (animal instanceof Raven) {
                Raven.incrementCount();
            } else if (animal instanceof Sheep) {
                Sheep.incrementCount();
            }

            return true;
        } else if (this.animalNames.contains(animal.getName())) {
            throw new IllegalNameException("Animal with this name already exists in the farm");
        } else {
            return false;
        }
    }

    public boolean removeAnimal(String name) {
        for (int i = 0; i < this.numberOfAnimals; i++) {
            if (this.animalList.get(i).getName().equals(name)) {
                Animal animal = this.animalList.get(i);
                this.animalList.remove(i);
                this.animalNames.remove(name);
                this.numberOfAnimals--;

                if (animal instanceof Chicken) {
                    Chicken.decrementCount();
                } else if (animal instanceof Donkey) {
                    Donkey.decrementCount();
                } else if (animal instanceof Horse) {
                    Horse.decrementCount();
                } else if (animal instanceof Pig) {
                    Pig.decrementCount();
                } else if (animal instanceof Raven) {
                    Raven.decrementCount();
                } else if (animal instanceof Sheep) {
                    Sheep.decrementCount();
                }

                return true;
            }
        }

        return false;
    }

    public void printAllAnimalGreetings() {
        for (Animal animal : this.animalList) {
            printOneAnimalGreeting(animal);
        }
    }

    public void printOneAnimalGreeting(Animal animal) {
        animal.sayGreeting();
    }

    public void printAllAnimalNames() {
        for (Animal animal : this.animalList) {
            printOneAnimalName(animal);
        }
    }

    public void printOneAnimalName(Animal animal) {
        System.out.println(animal.getName());
    }

    public void printAllAnimals() {
        for (Animal animal : this.animalList) {
            System.out.println(animal.toString());
        }
    }

    public int nextYearPopulationForecast() {
        int totalOffsprings = 0;
        for (Animal animal : this.animalList) {
            totalOffsprings += animal.getNumberOfOffsprings();
        }
        return this.numberOfAnimals + totalOffsprings;
    }

    public void animalMovements() {
        for (Animal animal : this.animalList) {
            if (animal instanceof Bird) {
                ((Bird) animal).fly();
            } else if (animal instanceof Mammal) {
                ((Mammal) animal).walk();
            }
        }
    }

    public void eatingHabits() {
        for (Animal animal : this.animalList) {
            if (animal instanceof Bird) {
                ((Bird) animal).omnivore();
            } else if (animal instanceof Mammal) {
                ((Mammal) animal).herbivore();
            }
        }
    }
    
    public void sortAlphabetically() {
        ArrayList<Animal> sortedList = new ArrayList<>(animalList);
        Collections.sort(sortedList, Comparator.comparing(Animal::getName));
        for (Animal animal : sortedList) {
            System.out.println(animal.toString());
        }
    }

    public void sortBasedOnLegNumber() {
        ArrayList<Animal> sortedList = new ArrayList<>(animalList);
        Collections.sort(sortedList, Comparator.comparing(Animal::getLegNumber));
        for (Animal animal : sortedList) {
            System.out.println(animal.toString());
        }
    }
    
    public void sortBasedOnAge() {
        Collections.sort(this.animalList, Comparator.comparingInt(Animal::getAge));
        for (Animal animal : this.animalList) {
            System.out.println(animal);
        }
    }

    public void searchBasedOnName(String name) {
        for (Animal animal : this.animalList) {
            if (animal.getName().equals(name)) {
                System.out.println(animal);
                return;
            }
        }
        System.out.println("No animal with name " + name + " found.");
    }

    public void searchBasedOnAge(int age) {
        boolean found = false;
        for (Animal animal : this.animalList) {
            if (animal.getAge() == age) {
                System.out.println(animal);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No animal with age " + age + " found.");
        }
    }

    public void printReport(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write("Total number of animals: " + this.numberOfAnimals + "\n");
            fw.write("----\n");
            for (String name : this.animalNames) {
                fw.write(name + "s:\n");
                for (Animal animal : this.animalList) {
                    if (animal.getName().equals(name)) {
                        fw.write("Name: " + animal.getName() + ", Age: " + animal.getAge() + ", Legs: " + animal.getLegNumber() + "\n");
                    }
                }
                fw.write("----\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
    
    
           
