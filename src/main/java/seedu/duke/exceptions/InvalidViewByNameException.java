package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_FIND_BY_NAME_MESSAGE;

public class InvalidViewByNameException extends DukeException {
    public InvalidViewByNameException() {
        super(INVALID_FIND_BY_NAME_MESSAGE);
    }
}
