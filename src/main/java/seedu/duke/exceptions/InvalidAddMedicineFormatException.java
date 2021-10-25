package seedu.duke.exceptions;

import static seedu.duke.common.Messages.ADD_MED_FORMAT_MESSAGE;

public class InvalidAddMedicineFormatException extends DukeException {
    public InvalidAddMedicineFormatException() {
        super(ADD_MED_FORMAT_MESSAGE);
    }
}
