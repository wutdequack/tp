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
        String listOfRecordsString = records
                .stream()
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
        String listOfAppointmentsString = appointments
                .stream()
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
        String listOfMedicinesString = medicines
                .stream()
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
        String listOfNoksString = nextofkins
                .stream()
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
        String vaccinatedString = String.format(MESSAGE_VACCINATED, username,
                isVaccinated ? "Vaccinated" : "Not vaccinated");
        String birthdayString = String.format(MESSAGE_BIRTHDAY, username,
                birthday == null ? "Not Recorded" : getBirthday());
        String combinedListofRecordsString = String.format(MESSAGE_RECORDS, username, listOfRecordsString);
        String combinedlistOfAppointmentsString = String.format(MESSAGE_APPOINTMENTS,
                listOfAppointmentsString);
        String combinedlistOfMedicinesString = String.format(MESSAGE_MEDICINES,
                listOfMedicinesString);
        String combinedlistOfNoksString = String.format(MESSAGE_NOKS, username,
                listOfNoksString);
        return String.format(MESSAGE_LOW_RISK_ELDERLY, username, name, vaccinatedString,
                birthdayString, combinedListofRecordsString,
                combinedlistOfAppointmentsString, combinedlistOfMedicinesString, combinedlistOfNoksString);
    }
}
