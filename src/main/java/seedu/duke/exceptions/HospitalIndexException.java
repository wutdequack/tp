package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_HOSPITAL_INDEX_MESSAGE;

public class HospitalIndexException extends DukeException {
    public HospitalIndexException() {
        super(INVALID_HOSPITAL_INDEX_MESSAGE);
    }

}
