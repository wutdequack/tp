package seedu.duke.common;

import static seedu.duke.common.MagicValues.DEFAULT_FILE_PATH;
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

    protected ArrayList<Medicine> medicines = new ArrayList<>();
    protected ArrayList<Appointment> appointments = new ArrayList<>();
    protected ArrayList<NextOfKin> nextofkins = new ArrayList<>();
    protected ArrayList<Record> records = new ArrayList<>();

    protected final String username;
    protected String name;

    protected Integer[] bloodPressure = new Integer[2];
    protected boolean isVaccinated;
    protected Date birthday;
    protected DietaryPreference diet;

    protected String medicalHistory;

    @SerializedName("type")
    private String typeName;

    public Elderly(String username, String name) {
        this.username = username;
        this.name = name;
        medicalHistory = new String();
        diet = DietaryPreference.NOT_SET;
        typeName = getClass().getName();
        bloodPressure[INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY] = VALUE_DEFAULT_BP;
        bloodPressure[INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY] = VALUE_DEFAULT_BP;
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
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void addNok(NextOfKin nextofkin) {
        nextofkins.add(nextofkin);
    }

    public Optional<NextOfKin> removeNok(String nextOfkin) {
        NextOfKin deleteNok;
        for (NextOfKin nok : nextofkins) {
            String currentNokName = nok.nokName.toLowerCase();
            if (currentNokName.contentEquals(nextOfkin.toLowerCase())) {
                deleteNok = nok;
                nextofkins.remove(nok);
                return Optional.of(deleteNok);
            }
        }
        return Optional.empty();
    }

    public Optional<Medicine> removeMedicine(String medName) {
        Medicine deleteMed;
        for (Medicine med : medicines) {
            String currentMedName = med.medicineName.toLowerCase();
            if (currentMedName.contentEquals(medName.toLowerCase())) {
                deleteMed = med;
                medicines.remove(med);
                return Optional.of(deleteMed);
            }
        }
        return Optional.empty();
    }

    public Optional<Appointment> removeAppointment(String deleteDate, String deleteTime) {
        Appointment deletedAppointment;
        for (Appointment appointment : appointments) {
            String currentDate = appointment.date;
            String currentTime = appointment.time;
            if (currentDate.contentEquals(deleteDate) && currentTime.contentEquals(deleteTime)) {
                deletedAppointment = appointment;
                appointments.remove(appointment);
                return Optional.of(deletedAppointment);
            }
        }
        return Optional.empty();
    }

    public void addRecord(Record record) {
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

    public void setBloodPressure(Integer systolic, Integer diastolic) {
        bloodPressure = new Integer[LENGTH_OF_BLOOS_PRESSURE_ARRAY];
        bloodPressure[INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY] = systolic;
        bloodPressure[INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY] = diastolic;
    }

    public Integer[] getBloodPressure() {
        return bloodPressure;
    }

    public void setVaccinated() {
        isVaccinated = true;
    }

    public Boolean isBloodPressureSet() {
        return bloodPressure[INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY] != VALUE_DEFAULT_BP;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setElderlyBirthday(String birthday) {
        try {
            if (!isValidDate(birthday)) {
                throw new InvalidDateFormatException();
            }
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthday = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            ui.printGeneralException(e);
        }
    }

    private static boolean isValidDate(String date) {
        int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        try {
            int year = Integer.parseInt(date.substring(0, 4));
            if (year <= 0)
                return false;
            int month = Integer.parseInt(date.substring(5, 7));
            if (month <= 0 || month > 12)
                return false;
            int day = Integer.parseInt(date.substring(8, 10));
            if (day <= 0 || day > DAYS[month])
                return false;
            if (month == 2 && day == 29 && !isGregorianLeapYear(year)) {
                return false;
            }
            int hour = Integer.parseInt(date.substring(11, 13));
            if (hour < 0 || hour > 23)
                return false;
            int minute = Integer.parseInt(date.substring(14, 16));
            if (minute < 0 || minute > 59)
                return false;
            int second = Integer.parseInt(date.substring(17, 19));
            if (second < 0 || second > 59)
                return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static final boolean isGregorianLeapYear(int year) {
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
            return "Error";
        }
    }

    public void setDietByUserChoice() {
        System.out.printf(PROMPT_LIST_OF_DIETS);
        int choice;
        try {
            choice = Integer.parseInt(ui.getUserInput());
        } catch (NumberFormatException e) {
            ui.printGeneralException(e);
            return;
        }
        Optional<DietaryPreference> dietaryPreference = getDietFromChoice(choice);
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

    private Optional<DietaryPreference> getDietFromChoice(int choice) {
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

    public void printDietaryPreference() {
        if (diet == DietaryPreference.NOT_SET) {
            System.out.printf("Dietary preference of %s has not been set%n", name);
            return;
        }
        System.out.printf("%s is having a %s diet%n", name, getDiet());
    }

    private void updateMedicalHistory(StringBuffer newMedicalHistory) {
        medicalHistory = newMedicalHistory.toString();
    }

    public void setMedicalHistory() {
        String currentHistory = medicalHistory;
        System.out.printf(PROMPT_KEY_IN_MEDICAL_HISTORY);
        String addedHistory = ui.getUserInput();
        StringBuffer currentHistoryStringBuffer = new StringBuffer();
        currentHistoryStringBuffer.append(currentHistory);
        if (!currentHistory.isEmpty()) {
            currentHistoryStringBuffer.append("\r\n");
        }
        currentHistoryStringBuffer.append(addedHistory);
        updateMedicalHistory(currentHistoryStringBuffer);
    }

    public void printMedicalHistory() {
        System.out.printf("%s's medical history:%n%s%n", name, medicalHistory);
    }

    public Elderly deleteMedicalHistory() {
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
            bloodPressureString = String.format("Blood pressure of %s is now (%d %d)%n", name,
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
        return String.format(MESSAGE_OVERALL_ELDERLY, username, name, vaccinatedString, bloodPressureString,
                birthdayString, combinedListofRecordsString,
                combinedListOfAppointmentsString, combinedListOfMedicinesString, combinedListOfNoksString);
    }
}

