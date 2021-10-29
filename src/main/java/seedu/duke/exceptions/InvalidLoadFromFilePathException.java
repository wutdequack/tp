package seedu.duke.exceptions;

import static seedu.duke.common.Messages.LOAD_FORMAT_MESSAGE;

public class InvalidLoadFromFilePathException extends InvalidInputException {
    public InvalidLoadFromFilePathException() {
        super(LOAD_FORMAT_MESSAGE);
    }

}
