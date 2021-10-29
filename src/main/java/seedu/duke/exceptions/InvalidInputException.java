package seedu.duke.exceptions;

public abstract class InvalidInputException extends DukeException {
    public InvalidInputException(String message) {
        super("Correct input format: " + message);
    }
}
