package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_ADD_RECORD_MESSAGE;

public class InvalidElderlyRecordFormatException extends DukeException {
    public InvalidElderlyRecordFormatException() {
        super(INVALID_ADD_RECORD_MESSAGE);
    }
}
