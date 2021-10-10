package seedu.duke.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Elderly {

    protected ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    protected ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    protected ArrayList<NextOfKin> nextofkins = new ArrayList<NextOfKin>();
    protected ArrayList<Record> records = new ArrayList<Record>();

    protected String name;

    private double[] bloodPressure;
    private boolean isVaccinated;
    private Date birthday;

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

    public void setBloodPressure(double systolic, double diastolic) {
        bloodPressure = new double[2];
        bloodPressure[0] = systolic;
        bloodPressure[1] = diastolic;
    }

    public double[] getBloodPressure() {
        return bloodPressure;
    }

    public void setVaccinated() {
        isVaccinated = true;
    }

    public void updateVaccinationStatus(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setBirthday(String birthday) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthday = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            System.out.println("Error in parsing");
            // todo : to be handled later
        }
    }

    public Date getBirthday() {
        return birthday;
    }
}

