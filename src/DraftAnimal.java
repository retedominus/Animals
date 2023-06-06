public class DraftAnimal extends Animal {
    public DraftAnimal(String name) {
        super(name);
    }

    @Override
    public void addNewCommand(String command) {
        addCommand(command);
    }
}
