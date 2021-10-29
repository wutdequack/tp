package seedu.duke.exceptions;

import static seedu.duke.common.Messages.STORE_FORMAT_MESSAGE;

public class InvalidStoreToFilePathException extends InvalidInputException {
    public InvalidStoreToFilePathException() {
        super(STORE_FORMAT_MESSAGE);
    }

}
