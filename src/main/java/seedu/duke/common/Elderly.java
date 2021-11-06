package seedu.duke.common;

import static seedu.duke.common.MagicValues.INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY;
import static seedu.duke.common.MagicValues.INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY;
import static seedu.duke.common.MagicValues.LENGTH_OF_BLOOS_PRESSURE_ARRAY;
import static seedu.duke.common.MagicValues.INPUT_HALAL;
import static seedu.duke.common.MagicValues.INPUT_VEGETARIAN;
import static seedu.duke.common.MagicValues.INPUT_VEGAN;
import static seedu.duke.common.MagicValues.INPUT_BEEF_FREE;
import static seedu.duke.common.MagicValues.INPUT_DIABETES;
import static seedu.duke.common.MagicValues.INPUT_NO_RESTRICTIONS;

import static seedu.duke.common.MagicValues.VALUE_DEFAULT_BP;
import static seedu.duke.common.Messages.MESSAGE_APPOINTMENTS;
import static seedu.duke.common.Messages.MESSAGE_BIRTHDAY;
import static seedu.duke.common.Messages.MESSAGE_BLOODPRESSURE;
import static seedu.duke.common.Messages.MESSAGE_MEDICALHIST;
import static seedu.duke.common.Messages.MESSAGE_MEDICINES;
import static seedu.duke.common.Messages.MESSAGE_NOKS;
import static seedu.duke.common.Messages.MESSAGE_NO_BLOOD_PRESSURE;
import static seedu.duke.common.Messages.MESSAGE_OVERALL_ELDERLY;
import static seedu.duke.common.Messages.MESSAGE_RECORDS;
import static seedu.duke.common.Messages.MESSAGE_VACCINATED;
import static seedu.duke.common.Messages.PROMPT_LIST_OF_DIETS;
import static seedu.duke.common.Messages.PROMPT_KEY_IN_MEDICAL_HISTORY;
import static seedu.duke.common.Messages.PROMPT_DELETE_MEDICAL_HISTORY;
import static seedu.duke.common.MagicValues.ui;

import com.google.gson.annotations.SerializedName;
import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.InvalidDateFormatException;
import seedu.duke.exceptions.InvalidDietIndexException;
import seedu.duke.exceptions.InvalidInputException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;


public abstract class Elderly {

    private ArrayList<Medicine> medicines = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<NextOfKin> nextofkins = new ArrayList<>();
    private ArrayList<Record> records = new ArrayList<>();

    private final String username;
    private final String name;

    private int[] bloodPressure;
    private boolean isVaccinated;
    private Date birthday;
    private DietaryPreference diet;

    private String medicalHistory;

    @SerializedName("type")
    private String typeName;

    public Elderly(String username, String name) {
        this.username = username;
        this.name = name;
        medicalHistory = new String();
        diet = DietaryPreference.NOT_SET;
        typeName = getClass().getName();
        bloodPressure = new int[]{VALUE_DEFAULT_BP, VALUE_DEFAULT_BP};
    }

    /**
     * Returns the elderly's username.
     *
     * @return Username of the elderly.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the elderly's name.
     *
     * @return Name of the elderly.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a medicine to the elderly's medicine ArrayList.
     *
     * @param medicine Medicine to be added.
     */
    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    /**
     * Adds an appointment to elderly's appointment ArrayList.
     *
     * @param appointment Appointment to be added.
     */
    public void addElderlyAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void addElderlyNok(NextOfKin nextofkin) {
        nextofkins.add(nextofkin);
    }

    public Optional<NextOfKin> removeElderlyNok(String nextOfkin) {
        NextOfKin deleteNok;
        for (NextOfKin nok : nextofkins) {
            String currentNokName = nok.getNokName().toLowerCase();
            if (currentNokName.contentEquals(nextOfkin.toLowerCase())) {
                deleteNok = nok;
                nextofkins.remove(nok);
                System.gc();
                return Optional.of(deleteNok);
            }
        }
        return Optional.empty();
    }

    public Optional<Medicine> removeElderlyMedicine(String medName) {
        Medicine deleteMedicine;
        for (Medicine med : medicines) {
            String currentMedName = med.getMedicineName().toLowerCase();
            if (currentMedName.contentEquals(medName.toLowerCase())) {
                deleteMedicine = med;
                medicines.remove(med);
                System.gc();
                return Optional.of(deleteMedicine);
            }
        }
        return Optional.empty();
    }

    public Optional<Appointment> removeAppointment(String deleteDate, String deleteTime) {
        Appointment deletedAppointment;
        for (Appointment appointment : appointments) {
            String currentDate = appointment.getDate();
            String currentTime = appointment.getTime();
            if (currentDate.contentEquals(deleteDate) && currentTime.contentEquals(deleteTime)) {
                deletedAppointment = appointment;
                appointments.remove(appointment);
                System.gc();
                return Optional.of(deletedAppointment);
            }
        }
        return Optional.empty();
    }

    public void addElderlyRecord(Record record) {
        records.add(record);
    }

    /**
     * Returns the elderly's medicine ArrayList.
     *
     * @return Medicine ArrayList of the elderly.
     */
    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    /**
     * Returns the elderly's appointment ArrayList.
     *
     * @return Appointment ArrayList of the elderly.
     */
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public ArrayList<NextOfKin> getNextOfKin() {
        return nextofkins;
    }

    public ArrayList<Record> getRecord() {
        return records;
    }

    public void setElderlyBloodPressure(Integer systolic, Integer diastolic) {
        bloodPressure = new int[LENGTH_OF_BLOOS_PRESSURE_ARRAY];
        bloodPressure[INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY] = systolic;
        bloodPressure[INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY] = diastolic;
    }

    public int[] getElderlyBloodPressure() {
        return bloodPressure;
    }

    public void setElderlyVaccinated() {
        isVaccinated = true;
    }

    public Boolean isBloodPressureSet() {
        return bloodPressure[INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY] != VALUE_DEFAULT_BP;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public boolean setElderlyBirthday(String birthday) {
        try {
            if (!isValidDate(birthday)) {
                throw new InvalidDateFormatException();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            this.birthday = simpleDateFormat.parse(birthday);
            return true;
        } catch (InvalidInputException e) {
            ui.printInvalidInputException(e);
            return false;
        } catch (ParseException e) {
            ui.printGeneralException(e);
            return false;
        }
    }

    private static boolean isValidDate(String date) {
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        try {
            int year = Integer.parseInt(date.substring(0, 4));
            if (year <= 0) {
                return false;
            }
            int month = Integer.parseInt(date.substring(5, 7));
            if (month <= 0 || month > 12) {
                return false;
            }
            int day = Integer.parseInt(date.substring(8, 10));
            if (day <= 0 || day > days[month]) {
                return false;
            }
            if (month == 2 && day == 29 && !isGregorianLeapYear(year)) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean isGregorianLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public String getBirthday() {
        return new SimpleDateFormat("yyyy-MM-dd").format(birthday);
    }

    public void printVaccinationStatus() {
        System.out.printf("%s is currently ", name);
        if (!isVaccinated) {
            System.out.printf("not ");
        }
        System.out.printf("vaccinated.%n");
    }

    public String getElderlyDiet() {
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
            return "Error";
        }
    }

    public void setElderlyDietByUserChoice() {
        System.out.printf(PROMPT_LIST_OF_DIETS);
        int choice;
        try {
            choice = Integer.parseInt(ui.getUserInput());
        } catch (NumberFormatException e) {
            ui.printGeneralException(e);
            return;
        }
        Optional<DietaryPreference> dietaryPreference = getElderlyDietFromChoice(choice);
        try {
            if (dietaryPreference.isPresent()) {
                this.diet = dietaryPreference.get();
            } else {
                throw new InvalidDietIndexException();
            }
        } catch (InvalidInputException e) {
            ui.printInvalidInputException(e);
        }
    }

    private Optional<DietaryPreference> getElderlyDietFromChoice(int choice) {
        switch (choice) {
        case INPUT_HALAL:
            return Optional.of(DietaryPreference.HALAL);
        case INPUT_VEGETARIAN:
            return Optional.of(DietaryPreference.VEGETARIAN);
        case INPUT_VEGAN:
            return Optional.of(DietaryPreference.VEGAN);
        case INPUT_BEEF_FREE:
            return Optional.of(DietaryPreference.BEEF_FREE);
        case INPUT_DIABETES:
            return Optional.of(DietaryPreference.DIABETES);
        case INPUT_NO_RESTRICTIONS:
            return Optional.of(DietaryPreference.NO_RESTRICTION);
        default:
            return Optional.empty();
        }
    }

    public void printElderlyDietaryPreference() {
        if (diet == DietaryPreference.NOT_SET) {
            System.out.printf("Dietary preference of %s has not been set%n", name);
            return;
        }
        System.out.printf("%s is having a %s diet%n", name, getElderlyDiet());
    }

    private void updateElderlyMedicalHistory(StringBuffer newMedicalHistory) {
        medicalHistory = newMedicalHistory.toString();
    }

    public void setElderlyMedicalHistory() {
        String currentHistory = medicalHistory;
        System.out.printf(PROMPT_KEY_IN_MEDICAL_HISTORY);
        String addedHistory = ui.getUserInput();
        StringBuffer currentHistoryStringBuffer = new StringBuffer();
        currentHistoryStringBuffer.append(currentHistory);
        if (!currentHistory.isEmpty()) {
            currentHistoryStringBuffer.append("\r\n");
        }
        currentHistoryStringBuffer.append(addedHistory);
        updateElderlyMedicalHistory(currentHistoryStringBuffer);
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void printElderlyMedicalHistory() {
        System.out.printf("%s's medical history:%n%s%n", name, medicalHistory);
    }

    public Elderly deleteElderlyMedicalHistory() {
        System.out.printf(PROMPT_DELETE_MEDICAL_HISTORY, name);
        String confirmationMessage = ui.getUserInput();
        if (!confirmationMessage.equalsIgnoreCase("Y")) {
            return null;
        }
        medicalHistory = new String();
        System.gc();
        return this;
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
        String bloodPressureString = "";
        if (!isBloodPressureSet()) {
            bloodPressureString = String.format(MESSAGE_NO_BLOOD_PRESSURE, name);
        } else {
            bloodPressureString = String.format(MESSAGE_BLOODPRESSURE, name,
                    bloodPressure[INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY],
                    bloodPressure[INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY]);
        }
        String vaccinatedString = String.format(MESSAGE_VACCINATED, username,
                isVaccinated ? "Vaccinated" : "Not vaccinated");
        String birthdayString = String.format(MESSAGE_BIRTHDAY, username,
                birthday == null ? "Not Recorded" : getBirthday());
        String combinedListofRecordsString = String.format(MESSAGE_RECORDS, username, listOfRecordsString);
        String combinedListOfAppointmentsString = String.format(MESSAGE_APPOINTMENTS,
                listOfAppointmentsString);
        String combinedListOfMedicinesString = String.format(MESSAGE_MEDICINES,
                listOfMedicinesString);
        String combinedListOfNoksString = String.format(MESSAGE_NOKS, username,
                listOfNoksString);
        String medicalHistoryString = String.format(MESSAGE_MEDICALHIST, getMedicalHistory());
        return String.format(MESSAGE_OVERALL_ELDERLY, username, name, vaccinatedString, bloodPressureString,
                birthdayString, medicalHistoryString, combinedListofRecordsString,
                combinedListOfAppointmentsString, combinedListOfMedicinesString, combinedListOfNoksString);
    }
}

