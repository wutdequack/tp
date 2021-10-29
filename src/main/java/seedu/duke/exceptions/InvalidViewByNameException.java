package seedu.duke.exceptions;

import static seedu.duke.common.Messages.FIND_BY_NAME_FORMAT_MESSAGE;

public class InvalidViewByNameException extends InvalidInputException {
    public InvalidViewByNameException() {
        super(FIND_BY_NAME_FORMAT_MESSAGE);
    }
}
