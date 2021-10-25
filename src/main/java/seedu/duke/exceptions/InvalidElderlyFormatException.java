package seedu.duke.exceptions;

import static seedu.duke.common.Messages.ADD_ELDERLY_FORMAT_MESSAGE;

public class InvalidElderlyFormatException extends DukeException {
    public InvalidElderlyFormatException() {
        super(ADD_ELDERLY_FORMAT_MESSAGE);
    }
}
