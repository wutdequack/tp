package seedu.duke.common;

import java.util.ArrayList;
import seedu.duke.hospital.Doctor;
import seedu.duke.hospital.Hospital;

public class HighRiskElderly extends Elderly {

    protected Hospital hospital;
    protected ArrayList<String> conditions;
    protected String notesOnCare;
    protected Doctor doctor;

    public HighRiskElderly(String name, Hospital hospital, ArrayList<String> conditions, String notesOnCare,
            Doctor doctor) {
        super(name);
        this.hospital = hospital;
        this.conditions = conditions;
        this.notesOnCare = notesOnCare;
        this.doctor = doctor;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }

    public String getNotesOnCare() {
        return notesOnCare;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
