package seedu.duke.exceptions;

import static seedu.duke.common.Messages.DELETE_APPOINTMENT_FORMAT_MESSAGE;

public class InvalidDeleteApptFormatException extends InvalidInputException {
    public InvalidDeleteApptFormatException() {
        super(DELETE_APPOINTMENT_FORMAT_MESSAGE);
    }
}
