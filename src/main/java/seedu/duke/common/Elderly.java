package seedu.duke.common;

import seedu.duke.parser.Parser;

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
import static seedu.duke.common.Messages.LIST_OF_DIETS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Elderly {

    protected ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    protected ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    protected ArrayList<NextOfKin> nextofkins = new ArrayList<NextOfKin>();
    protected ArrayList<Record> records = new ArrayList<Record>();

    protected String username;
    protected String name;

    private double[] bloodPressure;
    private boolean isVaccinated;
    private Date birthday;
    private DietaryPreference diet;

    public Elderly(String username, String name) {
        this.username = username;
        this.name = name;
        diet = DietaryPreference.NOT_SET;
    }

    public String getUsername() {
        return username;
    }
    
    public String getName () {
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
        System.out.printf("%s is currently ", getUsername());
        if (!isVaccinated) {
            System.out.printf("not ");
        }
        System.out.printf("vaccinated.%n");
    }

    public String getDiet() {
        switch (diet) {
        case HALAL:
            return "Halal";
        case VEGETARIAN:
            return "Vegetarian";
        case VEGAN:
            return "Vegan";
        case BEEF_FREE:
            return "Beef free";
        case DIABETES:
            return "Diabetes";
        case NO_RESTRICTION:
            return "No restriction";
        case NOT_SET:
            return "Not set";
        default:
            // to be handled by exception later
            return "Error";
        }
    }

    public void setDiet() {
        System.out.printf(LIST_OF_DIETS);
        int choice = Parser.parseChoiceFromUserInput();
        switch (choice) {
        case 1:
            diet = DietaryPreference.HALAL;
            break;
        case 2:
            diet = DietaryPreference.VEGETARIAN;
            break;
        case 3:
            diet = DietaryPreference.VEGAN;
            break;
        case 4:
            diet = DietaryPreference.BEEF_FREE;
            break;
        case 5:
            diet = DietaryPreference.DIABETES;
            break;
        case 6:
            diet = DietaryPreference.NO_RESTRICTION;
            break;
        default:
            // to be handled by exception later
            System.out.println("Wrong input");
        }
    }

    public void printDietaryPreference() {
        if (diet == DietaryPreference.NOT_SET) {
            System.out.printf("Dietary preference of %s has not been set%n", username);
            return;
        }
        System.out.printf("%s is having a %s diet%n", username, getDiet());
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
        String vaccinatedString = String.format(VACCINATED_MESSAGE, username,
                isVaccinated ? "Vaccinated" : "Not vaccinated");
        String birthdayString = String.format(BIRTHDAY_MESSAGE, username,
                birthday == null ? "Not Recorded" : getBirthday());
        String combinedListofRecordsString = String.format(RECORDS_MESSAGE, username, listOfRecordsString);
        String combinedlistOfAppointmentsString = String.format(APPOINTMENTS_MESSAGE,
                listOfAppointmentsString);
        String combinedlistOfMedicinesString = String.format(MEDICINES_MESSAGE,
                listOfMedicinesString);
        String combinedlistOfNoksString = String.format(NOKS_MESSAGE, username,
                listOfNoksString);
        return String.format(OVERALL_ELDERLY_MESSAGE, username, name, vaccinatedString,
                birthdayString, combinedListofRecordsString,
                combinedlistOfAppointmentsString, combinedlistOfMedicinesString, combinedlistOfNoksString);
    }
}

