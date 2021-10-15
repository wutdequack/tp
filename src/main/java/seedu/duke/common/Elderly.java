package seedu.duke.common;

import static seedu.duke.common.MagicValues.INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY;
import static seedu.duke.common.MagicValues.INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY;
import static seedu.duke.common.MagicValues.LENGTH_OF_BLOOS_PRESSURE_ARRAY;
import static seedu.duke.common.Messages.APPOINTMENTS_MESSAGE;
import static seedu.duke.common.Messages.BIRTHDAY_MESSAGE;
import static seedu.duke.common.Messages.MEDICINES_MESSAGE;
import static seedu.duke.common.Messages.NOKS_MESSAGE;
import static seedu.duke.common.Messages.OVERALL_ELDERLY_MESSAGE;
import static seedu.duke.common.Messages.RECORDS_MESSAGE;
import static seedu.duke.common.Messages.VACCINATED_MESSAGE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;


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
        bloodPressure = new double[LENGTH_OF_BLOOS_PRESSURE_ARRAY];
        bloodPressure[INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY] = systolic;
        bloodPressure[INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY] = diastolic;
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

    public void setElderlyBirthday(String birthday) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthday = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            System.out.println("Error in parsing");
            // todo : to be handled later
        }
    }

    public String getBirthday() {
        return new SimpleDateFormat("yyyy-MM-dd").format(birthday);
    }

    public void printVaccinationStatus() {
        System.out.printf("%s is currently ", getName());
        if (!isVaccinated) {
            System.out.printf("not ");
        }
        System.out.printf("vaccinated.%n");
    }

    @Override
    public String toString() {
        String listOfRecordsString = records
                .stream()
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
        String listOfAppointmentsString = appointments
                .stream()
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
        String listOfMedicinesString = medicines
                .stream()
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
        String listOfNoksString = nextofkins
                .stream()
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
        String vaccinatedString = String.format(VACCINATED_MESSAGE, name,
                isVaccinated ? "Vaccinated" : "Not vaccinated");
        String birthdayString = String.format(BIRTHDAY_MESSAGE, name,
                birthday == null ? "Not Recorded" : getBirthday());
        String combinedListofRecordsString = String.format(RECORDS_MESSAGE, name, listOfRecordsString);
        String combinedlistOfAppointmentsString = String.format(APPOINTMENTS_MESSAGE,
                listOfAppointmentsString);
        String combinedlistOfMedicinesString = String.format(MEDICINES_MESSAGE,
                listOfMedicinesString);
        String combinedlistOfNoksString = String.format(NOKS_MESSAGE, name,
                listOfNoksString);
        return String.format(OVERALL_ELDERLY_MESSAGE, name, vaccinatedString,
                birthdayString, combinedListofRecordsString,
                combinedlistOfAppointmentsString, combinedlistOfMedicinesString, combinedlistOfNoksString);
    }
}

