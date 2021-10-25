package seedu.duke.exceptions;

import static seedu.duke.common.Messages.ADD_RECORD_FORMAT_MESSAGE;

public class InvalidAddRecordFormatException extends DukeException {
    public InvalidAddRecordFormatException() {
        super(ADD_RECORD_FORMAT_MESSAGE);
    }

}
