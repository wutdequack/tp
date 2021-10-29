package seedu.duke.common;

import java.util.ArrayList;
import java.util.Objects;

import seedu.duke.hospital.Hospital;

import static seedu.duke.common.Messages.APPOINTMENTS_MESSAGE;
import static seedu.duke.common.Messages.BIRTHDAY_MESSAGE;
import static seedu.duke.common.Messages.MEDIUM_RISK_ELDERLY_MESSAGE;
import static seedu.duke.common.Messages.MEDICINES_MESSAGE;
import static seedu.duke.common.Messages.NOKS_MESSAGE;
import static seedu.duke.common.Messages.RECORDS_MESSAGE;
import static seedu.duke.common.Messages.VACCINATED_MESSAGE;

public class MediumRiskElderly extends Elderly implements Hospitalisable{

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
        String hospital = String.format("Hospital Details :\n%s\n", getHospital());
        String conditions = String.format("Conditions of elderly %s : %s\n", username, getConditions());
        String notesOnCare = String.format("Notes on care for %s : %s\n", username, getNotesOnCare());
        return String.format(MEDIUM_RISK_ELDERLY_MESSAGE, username, name, vaccinatedString,
                birthdayString, combinedListofRecordsString,
                combinedlistOfAppointmentsString, combinedlistOfMedicinesString, combinedlistOfNoksString, hospital,
                conditions, notesOnCare);
    }

}
