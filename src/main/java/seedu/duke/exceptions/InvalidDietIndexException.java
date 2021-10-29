package seedu.duke.exceptions;

import static seedu.duke.common.Messages.ERROR_IN_DIET_INDEX_MESSAGE;

public class InvalidDietIndexException extends InvalidInputException {
    public InvalidDietIndexException() {
        super(ERROR_IN_DIET_INDEX_MESSAGE);
    }
}
