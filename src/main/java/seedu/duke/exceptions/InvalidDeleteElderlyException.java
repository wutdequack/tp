package seedu.duke.exceptions;

import static seedu.duke.common.Messages.FIND_BY_MED_FORMAT_MESSAGE;

public class InvalidDeleteElderlyException extends DukeException {
    public InvalidDeleteElderlyException() {
        super(FIND_BY_MED_FORMAT_MESSAGE);
    }
}
