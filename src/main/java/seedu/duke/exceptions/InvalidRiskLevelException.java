package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_RISK_LEVEL_MESSAGE;

public class InvalidRiskLevelException extends DukeException {
    public InvalidRiskLevelException() {
        super(INVALID_RISK_LEVEL_MESSAGE);
    }

}
