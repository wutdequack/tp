package seedu.duke.common;

import java.util.Objects;

import seedu.duke.hospital.Hospital;

import static seedu.duke.common.Messages.MESSAGE_APPOINTMENTS;
import static seedu.duke.common.Messages.MESSAGE_BIRTHDAY;
import static seedu.duke.common.Messages.MESSAGE_MEDIUM_RISK_ELDERLY;
import static seedu.duke.common.Messages.MESSAGE_MEDICINES;
import static seedu.duke.common.Messages.MESSAGE_NOKS;
import static seedu.duke.common.Messages.MESSAGE_RECORDS;
import static seedu.duke.common.Messages.MESSAGE_VACCINATED;

public class MediumRiskElderly extends Elderly implements Hospitalisable {

    protected Hospital hospital;
    protected String conditions;
    protected String notesOnCare;

    public MediumRiskElderly(String username, String name, Hospital hospital, String conditions,
                             String notesOnCare) {
        super(username, name);
        this.hospital = hospital;
        this.conditions = conditions;
        this.notesOnCare = notesOnCare;
    }

    @Override
    public Hospital getHospital() {
        return hospital;
    }

    @Override
    public String getConditions() {
        return conditions;
    }

    @Override
    public String getNotesOnCare() {
        return notesOnCare;
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
        String combinedListOfAppointmentsString = String.format(MESSAGE_APPOINTMENTS,
                listOfAppointmentsString);
        String combinedListOfMedicinesString = String.format(MESSAGE_MEDICINES,
                listOfMedicinesString);
        String combinedListOfNoksString = String.format(MESSAGE_NOKS, username,
                listOfNoksString);
        String hospital = String.format("Hospital Details :\n%s\n", getHospital());
        String conditions = String.format("Conditions of elderly %s : %s\n", username, getConditions());
        String notesOnCare = String.format("Notes on care for %s : %s\n", username, getNotesOnCare());
        return String.format(MESSAGE_MEDIUM_RISK_ELDERLY, username, name, vaccinatedString,
                birthdayString, combinedListofRecordsString,
                combinedListOfAppointmentsString, combinedListOfMedicinesString, combinedListOfNoksString, hospital,
                conditions, notesOnCare);
    }

}
