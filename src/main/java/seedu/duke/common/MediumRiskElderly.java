package seedu.duke.common;

import java.util.ArrayList;
import seedu.duke.hospital.Hospital;

public class MediumRiskElderly extends Elderly {

    protected Hospital hospital;
    protected ArrayList<String> conditions;
    protected String notesOnCare;

    public MediumRiskElderly(String username, String name, Hospital hospital, ArrayList<String> conditions,
            String notesOnCare) {
        super(username, name);
        this.hospital = hospital;
        this.conditions = conditions;
        this.notesOnCare = notesOnCare;
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

}
