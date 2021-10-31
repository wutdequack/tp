package seedu.duke.common;

import java.util.Objects;

import seedu.duke.hospital.Doctor;
import seedu.duke.hospital.Hospital;

import static seedu.duke.common.Messages.MESSAGE_APPOINTMENTS;
import static seedu.duke.common.Messages.MESSAGE_BIRTHDAY;
import static seedu.duke.common.Messages.MESSAGE_MEDICINES;
import static seedu.duke.common.Messages.MESSAGE_HIGH_RISK_ELDERLY;
import static seedu.duke.common.Messages.MESSAGE_NOKS;
import static seedu.duke.common.Messages.MESSAGE_RECORDS;
import static seedu.duke.common.Messages.MESSAGE_VACCINATED;

public class HighRiskElderly extends Elderly implements Hospitalisable {

    protected Hospital hospital;
    protected String conditions;
    protected String notesOnCare;
    protected Doctor doctor;

    public HighRiskElderly(String username, String name, Hospital hospital, String conditions,
                           String notesOnCare,
                           Doctor doctor) {
        super(username, name);
        this.hospital = hospital;
        this.conditions = conditions;
        this.notesOnCare = notesOnCare;
        this.doctor = doctor;
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

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        String hospital = String.format("[*] Hospital Details :\n%s\n", getHospital());
        String conditions = String.format("[*] Conditions of elderly %s : %s\n", username, getConditions());
        String notesOnCare = String.format("[*] Notes on care for %s : %s\n", username, getNotesOnCare());
        String doctor = String.format("[*] Doctor for %s :\n%s\n", username, getDoctor());
        return String.format(MESSAGE_HIGH_RISK_ELDERLY, super.toString(), hospital, conditions, doctor, notesOnCare);
    }
}
