package seedu.duke.common;

import java.util.ArrayList;


public class Elderly {

    protected ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    protected ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    protected ArrayList<NextOfKin> nextofkins = new ArrayList<NextOfKin>();
    protected ArrayList<Record> records = new ArrayList<Record>();

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

    public void addNok(NextOfKin nextofkin) {
        nextofkins.add(nextofkin);
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public ArrayList<NextOfKin> getNextOfKin() {
        return nextofkins;
    }

    public ArrayList<Record> getRecord() {
        return records;
    }

}

