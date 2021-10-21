package seedu.duke.common;

import java.util.ArrayList;
import seedu.duke.hospital.Hospital;

public class MediumRiskElderly extends Elderly {

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

    public Hospital getHospital() {
        return hospital;
    }

    public String getConditions() {
        return conditions;
    }

    public String getNotesOnCare() {
        return notesOnCare;
    }

}
