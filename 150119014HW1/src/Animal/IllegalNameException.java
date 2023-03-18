package Animal;

@SuppressWarnings("serial")
public class IllegalNameException extends Exception {
    public IllegalNameException(String string) {
        super("This animal name already exists in the farm!");
    }
}

