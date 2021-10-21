package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_FIND_BY_DIET_MESSAGE;

public class InvalidViewDietException extends DukeException {
    public InvalidViewDietException() {
        super(INVALID_FIND_BY_DIET_MESSAGE);
    }
}