package seedu.duke.exceptions;

public abstract class InvalidInputException extends DukeException {
    public InvalidInputException(String correctInputMessage) {
        super("Correct input format: " + correctInputMessage);
    }
}
