package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_VIEW_MEDICINE_MESSAGE;

public class InvalidMedicineException extends DukeException {
    public InvalidMedicineException() {
        super(INVALID_VIEW_MEDICINE_MESSAGE);
    }
}
