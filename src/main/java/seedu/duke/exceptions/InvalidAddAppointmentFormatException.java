package seedu.duke.exceptions;

import static seedu.duke.common.Messages.ADD_APPOINTMENT_FORMAT_MESSAGE;

public class InvalidAddAppointmentFormatException extends InvalidInputException {
    public InvalidAddAppointmentFormatException() {
        super(ADD_APPOINTMENT_FORMAT_MESSAGE);
    }
}
