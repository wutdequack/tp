package seedu.duke.exceptions;

import static seedu.duke.common.Messages.FIND_BY_NAME_FORMAT_MESSAGE;

public class InvalidViewByNameException extends DukeException {
    public InvalidViewByNameException() {
        super(FIND_BY_NAME_FORMAT_MESSAGE);
    }
}
