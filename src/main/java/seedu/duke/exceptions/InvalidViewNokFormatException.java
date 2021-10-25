package seedu.duke.exceptions;

import static seedu.duke.common.Messages.VIEW_NOK_FORMAT_MESSAGE;

public class InvalidViewNokFormatException extends DukeException {
    public InvalidViewNokFormatException() {
        super(VIEW_NOK_FORMAT_MESSAGE);
    }

}