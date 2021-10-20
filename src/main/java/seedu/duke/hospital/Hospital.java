package seedu.duke.hospital;

import java.util.ArrayList;

public class Hospital {
    private String name;
    private Integer number;
    protected ArrayList<Doctor> doctorArrayList = new ArrayList<Doctor>();


    public Hospital(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getHospitalName() {
        return name;
    }

    public Integer getHospitalNumber() {
        return number;
    }

    public void getDoctors() {
        System.out.println("print all doctors lmao");
    }

}
