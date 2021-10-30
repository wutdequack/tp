package seedu.duke.exceptions;

import static seedu.duke.common.Messages.VIEW_RECORD_FORMAT_MESSAGE;

public class InvalidViewRecordFormatException extends InvalidInputException {
    public InvalidViewRecordFormatException() {
        super(VIEW_RECORD_FORMAT_MESSAGE);
    }

}