package seedu.duke.exceptions;

import static seedu.duke.common.Messages.ADD_NOK_FORMAT_MESSAGE;

public class InvalidNokFormatException extends DukeException {
    public InvalidNokFormatException() {
        super(ADD_NOK_FORMAT_MESSAGE);
    }

}
