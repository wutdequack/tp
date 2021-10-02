package seedu.duke.common;

import java.util.ArrayList;


public class Elderly {

    protected ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    protected ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    protected String name;

    public Elderly(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

}

