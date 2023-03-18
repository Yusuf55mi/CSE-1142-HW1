package Animal;

import java.util.Scanner;

public class AnimalFarmTest {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
    System.out.print("Enter the capacity of the animal farm: ");
    int capacity = input.nextInt();
    AnimalFarm farm = new AnimalFarm(capacity);
    int choice = -1;
    while (choice != 0) {
      System.out.println("\nMenu:");
      System.out.println("0. Exit");
      System.out.println("1. Add Animal");
      System.out.println("2. Remove Animal");
      System.out.println("3. Search Animal");
      System.out.println("4. Sort Animals");
      System.out.println("5. Next Year Population Forecast");
      System.out.println("6. Animal Movements");
      System.out.println("7. Eating Habits");
      System.out.println("8. Print Report");
      System.out.print("Enter your choice:");
      choice = input.nextInt();
      switch (choice) {
        case 0:
          System.out.println("Goodbye!");
          break;
        case 1:
          System.out.println("\nChoose animal type:");
          System.out.println("1. Chicken");
          System.out.println("2. Pig");
          System.out.println("3. Donkey");
          System.out.print("Enter your choice:");
          int animalChoice = input.nextInt();
          System.out.print("Enter animal name:");
          String name = input.next();
          System.out.print("Enter animal age:");
          int age = input.nextInt();
          try {
            boolean added = false;
            switch (animalChoice) {
              case 1:
                Chicken chicken = new Chicken(name, age);
                added = farm.addAnimal(chicken);
                break;
              case 2:
                Pig pig = new Pig(name, age);
                added = farm.addAnimal(pig);
                break;
              case 3:
                Donkey donkey = new Donkey(name, age);
                added = farm.addAnimal(donkey);
                break;
              default:
                System.out.println("Invalid choice.");
                break;
            }
            if (added) {
              System.out.println("Animal added successfully.");
            } else {
              System.out.println("Animal could not be added.");
            }
          } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
          }
          break;
        case 2:
          System.out.print("Enter animal name: ");
          name = input.next();
          boolean removed = farm.removeAnimal(name);
          if (removed) {
            System.out.println("Animal removed successfully.");
          } else {
            System.out.println("Animal could not be removed.");
          }
          break;
        case 3:
          System.out.println("\nChoose search criteria:");
          System.out.println("1 - Search based on name");
          System.out.println("2 - Search based on age");
          System.out.print("Enter your choice: ");
          int searchChoice = input.nextInt();
          switch (searchChoice) {
            case 1:
            	System.out.print("Enter animal name:");
            	name = input.next();
            	farm.searchBasedOnName(name);
            	break;
            case 2:
                System.out.print("Enter animal age:");
                age = input.nextInt();
                farm.searchBasedOnAge(age);
                break;
            default:
            	System.out.println("Invalid choice.");
                break;
            }
          break;
        case 4:
        	System.out.println("\nChoose sort criteria:");
            System.out.println("1 - Sort based on name");
            System.out.println("2 - Sort based on leg number");
            System.out.println("3 - Sort based on age");
            System.out.println("4 - Sort based on addition date");
            System.out.print("Enter your choice: ");
            int sortChoice = input.nextInt();
            switch (sortChoice) {
            case 1:
            	farm.sortAlphabetically();
            	break;
            case 2:
            	farm.sortBasedOnLegNumber();
            	break;
            case 3:
            	farm.sortBasedOnAge();
            	break;
            case 4:
            	System.out.println("There is no data for addition date!");
            	break;
            default:
            	System.out.println("Invalid choice.");
                break;
            }
            break;
        case 5:
        	System.out.println(farm.nextYearPopulationForecast());
        	break;
        case 6:
        	farm.animalMovements();
        	break;
        case 7:
        	farm.eatingHabits();
        	break;
        case 8:
        	System.out.print("Enter filename:");
            String fileName = input.next();
            farm.printReport(fileName);
            break;
      }
      }
    }
  }
            
              
            
