package seedu.duke.exceptions;

import static seedu.duke.common.Messages.ADD_RECORD_FORMAT_MESSAGE;

public class InvalidElderlyRecordFormatException extends DukeException {
    public InvalidElderlyRecordFormatException() {
        super(ADD_RECORD_FORMAT_MESSAGE);
    }
}
