package seedu.duke.exceptions;

import static seedu.duke.common.Messages.DELETE_ELDERLY_FORMAT_MESSAGE;

public class InvalidDeleteElderlyException extends InvalidInputException {
    public InvalidDeleteElderlyException() {
        super(DELETE_ELDERLY_FORMAT_MESSAGE);
    }
}
