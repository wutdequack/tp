package seedu.duke.exceptions;

import static seedu.duke.common.Messages.VIEW_APPOINTMENT_FORMAT_MESSAGE;

public class InvalidViewAppointmentFormatException extends InvalidInputException {
    public InvalidViewAppointmentFormatException() {
        super(VIEW_APPOINTMENT_FORMAT_MESSAGE);
    }
}