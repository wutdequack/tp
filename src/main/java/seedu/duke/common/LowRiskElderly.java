package seedu.duke.common;

import java.util.Objects;

import static seedu.duke.common.Messages.MESSAGE_APPOINTMENTS;
import static seedu.duke.common.Messages.MESSAGE_BIRTHDAY;
import static seedu.duke.common.Messages.MESSAGE_MEDICINES;
import static seedu.duke.common.Messages.MESSAGE_NOKS;
import static seedu.duke.common.Messages.MESSAGE_LOW_RISK_ELDERLY;
import static seedu.duke.common.Messages.MESSAGE_RECORDS;
import static seedu.duke.common.Messages.MESSAGE_VACCINATED;

public class LowRiskElderly extends Elderly {

    public LowRiskElderly(String username, String name) {
        super(username, name);
    }

    @Override
    public String toString() {
        return String.format(MESSAGE_LOW_RISK_ELDERLY, super.toString());
    }
}
