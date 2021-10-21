package seedu.duke.exceptions;

import static seedu.duke.common.Messages.VIEW_MED_FORMAT_MESSAGE;

public class InvalidMedicineException extends DukeException {
    public InvalidMedicineException() {
        super(VIEW_MED_FORMAT_MESSAGE);
    }
}
