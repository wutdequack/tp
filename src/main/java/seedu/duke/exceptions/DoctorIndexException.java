package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_DOCTOR_INDEX_MESSAGE;

public class DoctorIndexException extends DukeException {
    public DoctorIndexException() {
        super(INVALID_DOCTOR_INDEX_MESSAGE);
    }

}
