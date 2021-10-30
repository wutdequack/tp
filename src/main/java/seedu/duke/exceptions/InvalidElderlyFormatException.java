package seedu.duke.exceptions;

import static seedu.duke.common.Messages.ADD_ELDERLY_FORMAT_MESSAGE;

public class InvalidElderlyFormatException extends InvalidInputException {
    public InvalidElderlyFormatException() {
        super(ADD_ELDERLY_FORMAT_MESSAGE);
    }
}
