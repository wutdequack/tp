package seedu.duke.common;

public class ElderlyWithInfectiousDisease extends Elderly {
    private boolean isQuarantined;
    private String diseaseName;

    ElderlyWithInfectiousDisease(String name) {
        super(name);
    }
}
