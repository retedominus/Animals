import java.util.Scanner;

public class AnimalRegistryProgram {
    public static void main(String[] args) {
        try (AnimalRegistry registry = new AnimalRegistry()) {
            Scanner scanner = new Scanner(System.in);

            boolean running = true;
            while (running) {
                System.out.println("=== Animal Registry ===");
                System.out.println("1. Add new animal");
                System.out.println("2. List commands for an animal");
                System.out.println("3. Teach new command to an animal");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter animal type (Cat, Dog, Hamster, Donkey, Camel, Horse): ");
                        String animalType = scanner.nextLine();
                        System.out.print("Enter animal name: ");
                        String animalName = scanner.nextLine();
                        registry.addAnimal(animalType, animalName);
                    }
                    case 2 -> {
                        System.out.print("Enter animal name: ");
                        String name = scanner.nextLine();
                        registry.listCommands(name);
                    }
                    case 3 -> {
                        System.out.print("Enter animal name: ");
                        String animal = scanner.nextLine();
                        System.out.print("Enter new command: ");
                        String command = scanner.nextLine();
                        registry.teachCommand(animal, command);
                    }
                    case 4 -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}