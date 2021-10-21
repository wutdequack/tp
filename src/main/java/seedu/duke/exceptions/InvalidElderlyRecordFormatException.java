package seedu.duke.exceptions;

import static seedu.duke.common.Messages.DELETE_ELDERLY_FORMAT_MESSAGE;

public class InvalidElderlyRecordFormatException extends DukeException {
    public InvalidElderlyRecordFormatException() {
        super(DELETE_ELDERLY_FORMAT_MESSAGE);
    }
}
