package seedu.duke.exceptions;

import static seedu.duke.common.Messages.NO_SUCH_ELDERLY_MESSAGE;

public class ElderlyNotFoundException extends DukeException {
    public ElderlyNotFoundException() {
        super(NO_SUCH_ELDERLY_MESSAGE);
    }

}
