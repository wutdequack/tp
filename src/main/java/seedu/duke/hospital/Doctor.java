package seedu.duke.hospital;

public class Doctor {

    private String name;
    private Integer number;

    public Doctor(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getDoctorName() {
        return name;
    }

    public Integer getDoctorNumber() {
        return number;
    }
}
