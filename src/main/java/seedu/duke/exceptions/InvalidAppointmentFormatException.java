package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_ADD_APPOINTMENT_MESSAGE;

public class InvalidAppointmentFormatException extends DukeException {
    public InvalidAppointmentFormatException() {
        super(INVALID_ADD_APPOINTMENT_MESSAGE);
    }
}
