package seedu.duke.exceptions;

import static seedu.duke.common.Messages.INVALID_RISK_LEVEL_MESSAGE;

public class RiskLevelException extends DukeException {
    public RiskLevelException() {
        super(INVALID_RISK_LEVEL_MESSAGE);
    }

}
