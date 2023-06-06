public class PetAnimal extends Animal{
    public PetAnimal(String name) {
        super(name);
    }

    @Override
    public void addNewCommand(String command) {
        addCommand(command);
    }
}

