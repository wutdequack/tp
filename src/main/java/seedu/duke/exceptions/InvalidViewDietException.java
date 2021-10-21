package seedu.duke.exceptions;

import static seedu.duke.common.Messages.FIND_BY_DIET_FORMAT_MESSAGE;

public class InvalidViewDietException extends DukeException {
    public InvalidViewDietException() {
        super(FIND_BY_DIET_FORMAT_MESSAGE);
    }
}