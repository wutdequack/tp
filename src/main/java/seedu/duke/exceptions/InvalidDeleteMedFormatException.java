package seedu.duke.exceptions;

import static seedu.duke.common.Messages.DELETE_MEDICINE_FORMAT_MESSAGE;

public class InvalidDeleteMedFormatException extends DukeException {
    public InvalidDeleteMedFormatException() {
        super(DELETE_MEDICINE_FORMAT_MESSAGE);
    }
}
