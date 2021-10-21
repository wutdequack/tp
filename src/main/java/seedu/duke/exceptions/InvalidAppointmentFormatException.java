package seedu.duke.exceptions;

import static seedu.duke.common.Messages.ADD_APPOINTMENT_FORMAT_MESSAGE;

public class InvalidAppointmentFormatException extends DukeException {
    public InvalidAppointmentFormatException() {
        super(ADD_APPOINTMENT_FORMAT_MESSAGE);
    }
}
