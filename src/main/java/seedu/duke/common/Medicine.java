package seedu.duke.common;

public class Medicine {

    protected String medicineName;
    protected String frequency;

    public Medicine(String medicineName, String frequency) {
        this.medicineName = medicineName;
        this.frequency = frequency;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", getMedicineName(), getFrequency());
    }

}

