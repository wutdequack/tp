package seedu.duke.exceptions;

import static seedu.duke.common.Messages.MESSAGE_VIEW_MEDICAL_HISTORY_FORMAT;

public class InvalidViewMedicalHistoryFormat extends InvalidInputException {
    public InvalidViewMedicalHistoryFormat() {
        super(MESSAGE_VIEW_MEDICAL_HISTORY_FORMAT);
    }
}
