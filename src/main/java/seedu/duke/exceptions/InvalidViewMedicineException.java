package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_FIND_BY_MED_MESSAGE;

public class InvalidViewMedicineException extends DukeException {
    public InvalidViewMedicineException() {
        super(INVALID_FIND_BY_MED_MESSAGE);
    }
}
