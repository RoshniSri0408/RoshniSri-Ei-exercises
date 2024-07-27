import java.util.Scanner;
interface Animal {
    void displayType();
}
// Concrete class for Herbivore
class Herbivore implements Animal {
    @Override
    public void displayType() {
        System.out.println("I am a Herbivore. I eat plants.");
    }
}

// Concrete class for Carnivore
class Carnivore implements Animal {
    @Override
    public void displayType() {
        System.out.println("I am a Carnivore. I eat meat.");
    }
}

// Concrete class for Omnivore
class Omnivore implements Animal {
    @Override
    public void displayType() {
        System.out.println("I am an Omnivore. I eat both plants and meat.");
    }
}
// Factory class to create Animal objects
class AnimalFactory {
    public static Animal createAnimal(String foodType) {
        if (foodType.equalsIgnoreCase("plant")) {
            return new Herbivore();
        } else if (foodType.equalsIgnoreCase("meat")) {
            return new Carnivore();
        } else if (foodType.equalsIgnoreCase("both")) {
            return new Omnivore();
        } else {
            throw new IllegalArgumentException("Unknown food type: " + foodType);
        }
    }
}


public class AnimalFactoryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of food (plant, meat, both): ");
        String foodType = scanner.nextLine();

        try {
            Animal animal = AnimalFactory.createAnimal(foodType);
            animal.displayType();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

