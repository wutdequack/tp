package seedu.duke.exceptions;

import static seedu.duke.common.Messages.DELETE_NOK_FORMAT_MESSAGE;

public class InvalidDeleteNokFormatException extends DukeException {
    public InvalidDeleteNokFormatException() {
        super(DELETE_NOK_FORMAT_MESSAGE);
    }

}
