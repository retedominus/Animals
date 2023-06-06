import java.util.ArrayList;
import java.util.List;

public class AnimalRegistry implements AutoCloseable {
    private final List<Animal> animals;
    private int counter;

    public AnimalRegistry() {
        animals = new ArrayList<>();
        counter = 0;
    }

    public void addAnimal(String animalType, String animalName) {
        Animal animal = createAnimal(animalType, animalName);
        if (animal != null) {
            animals.add(animal);
            System.out.println("New animal added: " + animal.getName());
            counter++;
        }
    }

    public void listCommands(String animalName) {
        for (Animal animal : animals) {
            if (animal.getName().equals(animalName)) {
                System.out.println("Commands for " + animal.getName() + ":");
                animal.performCommands();
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    public void teachCommand(String animalName, String command) {
        for (Animal animal : animals) {
            if (animal.getName().equals(animalName)) {
                animal.addNewCommand(command);
                System.out.println("Command added to " + animal.getName() + ": " + command);
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    private Animal createAnimal(String animalType, String animalName) {
        Animal animal;
        switch (animalType.toLowerCase()) {
            case "cat" -> animal = new Cat(animalName);
            case "dog" -> animal = new Dog(animalName);
            case "hamster" -> animal = new Hamster(animalName);
            case "donkey" -> animal = new Donkey(animalName);
            case "camel" -> animal = new Camel(animalName);
            case "horse" -> animal = new Horse(animalName);
            default -> {
                System.out.println("Invalid animal type: " + animalType);
                return null;
            }
        }
        return animal;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void close() throws Exception {
        if (counter > 0) {
            throw new Exception("Resource was not used in a try-with-resources block or was left open.");
        }
    }
}