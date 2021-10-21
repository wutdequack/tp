package seedu.duke.common;

import java.util.ArrayList;
import seedu.duke.hospital.Doctor;
import seedu.duke.hospital.Hospital;

public class HighRiskElderly extends Elderly {

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

    public Hospital getHospital() {
        return hospital;
    }

    public String getConditions() {
        return conditions;
    }

    public String getNotesOnCare() {
        return notesOnCare;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
