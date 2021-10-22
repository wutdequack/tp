package seedu.duke.hospital;

public class Doctor {

    private String name;
    private Integer number;

    public Doctor(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    /**
     * Returns the doctor's name.
     *
     * @return Name of the doctor.
     */
    public String getDoctorName() {
        return name;
    }

    /**
     * Returns the doctor's number.
     *
     * @return Number of the doctor.
     */
    public Integer getDoctorNumber() {
        return number;
    }
}
