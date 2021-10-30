package seedu.duke.exceptions;

import static seedu.duke.common.Messages.FIND_BY_MED_FORMAT_MESSAGE;

public class InvalidViewMedicineException extends InvalidInputException {
    public InvalidViewMedicineException() {
        super(FIND_BY_MED_FORMAT_MESSAGE);
    }
}
