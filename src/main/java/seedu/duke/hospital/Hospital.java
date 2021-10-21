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

    public void printDoctorNames() {
        int counter = 1;
        System.out.println("List of " + getHospitalName() + " doctors are shown below:");
        for (Doctor doctor : doctorArrayList) {
            System.out.format("% 3d.", counter);
            System.out.println(doctor.getDoctorName());
            counter++;
        }
    }

    public Doctor getDoctor(int doctorIndex) {
        return doctorArrayList.get(doctorIndex);
    }

    public ArrayList<Doctor> getDoctors() {
        return doctorArrayList;
    }

    public void addDoctor(String name, Integer number) {
        doctorArrayList.add(new Doctor(name, number));
    }


}
