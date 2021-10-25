package seedu.duke.common;

import java.util.Objects;

import static seedu.duke.common.Messages.APPOINTMENTS_MESSAGE;
import static seedu.duke.common.Messages.BIRTHDAY_MESSAGE;
import static seedu.duke.common.Messages.MEDICINES_MESSAGE;
import static seedu.duke.common.Messages.NOKS_MESSAGE;
import static seedu.duke.common.Messages.LOW_RISK_ELDERLY_MESSAGE;
import static seedu.duke.common.Messages.RECORDS_MESSAGE;
import static seedu.duke.common.Messages.VACCINATED_MESSAGE;

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
        String vaccinatedString = String.format(VACCINATED_MESSAGE, username,
                isVaccinated ? "Vaccinated" : "Not vaccinated");
        String birthdayString = String.format(BIRTHDAY_MESSAGE, username,
                birthday == null ? "Not Recorded" : getBirthday());
        String combinedListofRecordsString = String.format(RECORDS_MESSAGE, username, listOfRecordsString);
        String combinedlistOfAppointmentsString = String.format(APPOINTMENTS_MESSAGE,
                listOfAppointmentsString);
        String combinedlistOfMedicinesString = String.format(MEDICINES_MESSAGE,
                listOfMedicinesString);
        String combinedlistOfNoksString = String.format(NOKS_MESSAGE, username,
                listOfNoksString);
        return String.format(LOW_RISK_ELDERLY_MESSAGE, username, name, vaccinatedString,
                birthdayString, combinedListofRecordsString,
                combinedlistOfAppointmentsString, combinedlistOfMedicinesString, combinedlistOfNoksString);
    }
}
