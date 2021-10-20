package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_ADD_NOK_MESSAGE;

public class InvalidNokFormatException extends DukeException {
    public InvalidNokFormatException() {
        super(INVALID_ADD_NOK_MESSAGE);
    }

}
