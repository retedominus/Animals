import java.util.*;

abstract class Animal {
    private final String name;
    private final List<String> commands;

    public Animal(String name) {
        this.name = name;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void performCommands() {
        System.out.println(name + " is performing commands:");
        for (String command : commands) {
            System.out.println("- " + command);
        }
    }

    public String getName() {
        return name;
    }

    public abstract void addNewCommand(String command);
}
