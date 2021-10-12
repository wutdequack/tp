package seedu.duke.list;

import java.util.ArrayList;
import seedu.duke.common.Elderly;
import seedu.duke.common.Medicine;
import seedu.duke.common.Appointment;
import seedu.duke.common.NextOfKin;
import seedu.duke.common.Record;


import java.util.Date;
import java.util.Objects;

//import seedu.duke.common.*;
import static seedu.duke.common.MagicValues.INDEX_OF_DATE;
import static seedu.duke.common.MagicValues.INDEX_OF_ELDERLY_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_ELDERLY_ADDRESS;
import static seedu.duke.common.MagicValues.INDEX_OF_FREQUENCY;
import static seedu.duke.common.MagicValues.INDEX_OF_LOCATION;
import static seedu.duke.common.MagicValues.INDEX_OF_ELDERLY_PHONE_NUMBER;
import static seedu.duke.common.MagicValues.INDEX_OF_MEDICINE_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_NOK_ADDRESS;
import static seedu.duke.common.MagicValues.INDEX_OF_NOK_EMAIL;
import static seedu.duke.common.MagicValues.INDEX_OF_NOK_PHONE_NUMBER;
import static seedu.duke.common.MagicValues.INDEX_OF_NOK_RELATIONSHIP;
import static seedu.duke.common.MagicValues.INDEX_OF_PURPOSE;
import static seedu.duke.common.MagicValues.INDEX_OF_TIME;
import static seedu.duke.common.MagicValues.LENGTH_IF_PURPOSE_EXISTS;
import static seedu.duke.common.MagicValues.INDEX_OF_NOK_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_BIRTHDAY;
import static seedu.duke.common.MagicValues.INDEX_OF_SYSTOLIC_PRESSURE;
import static seedu.duke.common.MagicValues.INDEX_OF_DIASTOLIC_PRESSURE;

import static seedu.duke.common.MagicValues.ui;
import static seedu.duke.common.Messages.NUMBER_OF_ELDERLY_STRING;


public class ElderlyList {


    protected static ArrayList<Elderly> elderlyArrayList = new ArrayList<Elderly>();

    public ElderlyList() {
    }

    /**
     * Returns the elderly array list.
     *
     * @return elderlyArrayList is the elderly array list.
     */
    public ArrayList<Elderly> getElderlyArrayList() {
        return elderlyArrayList;
    }

    /**
     * Adds the elderly into the elderly array list.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addElderly(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "Name is empty";
        String elderlyName = paramList[1];
        elderlyArrayList.add(new Elderly(elderlyName));
    }

    /**
     * Adds the medicine to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addMedicine(String userLine) {
        String[] paramList = userLine.split(" [nmf]/");
        assert paramList.length == 4 : "addmed input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        String medicineName = paramList[INDEX_OF_MEDICINE_NAME];
        String frequency = paramList[INDEX_OF_FREQUENCY];
        elderly.addMedicine(new Medicine(medicineName, frequency));
    }

    /**
     * Views all medicine the elderly needs to take based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void viewMedicine(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "Name is empty";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printMedicines(elderly);
    }

    /**
     * Prints all the medicine, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printMedicines(Elderly elderly) {
        int counter = 1;
        System.out.println("Medicine of " + elderly.getName() + " are shown below:");
        for (Medicine medicine : elderly.getMedicines()) {
            System.out.format("% 3d.", counter);
            System.out.println(medicine);
            counter++;
        }
    }

    /**
     * Adds the appointment to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addAppointment(String userLine) {
        String[] paramList = userLine.split(" [nldtp]/");
        assert paramList.length == 5 || paramList.length == 6 : "addappt input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        String location = paramList[INDEX_OF_LOCATION];
        String date = paramList[INDEX_OF_DATE];
        String time = paramList[INDEX_OF_TIME];
        String purpose;
        if (paramList.length == LENGTH_IF_PURPOSE_EXISTS) {
            purpose = paramList[INDEX_OF_PURPOSE];
        } else {
            purpose = "general checkup";
        }
        elderly.addAppointment(new Appointment(location, date, time, purpose));
    }

    /**
     * Views all appointments the elderly has based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void viewAppointment(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "Name is empty";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printAppointments(elderly);
    }

    /**
     * Prints all the appointments, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printAppointments(Elderly elderly) {
        int counter = 1;
        System.out.println("Appointments of " + elderly.getName() + " are shown below:");
        for (Appointment appointment : elderly.getAppointments()) {
            System.out.format("% 3d.", counter);
            System.out.println(appointment);
            counter++;
        }
    }

    /**
     * Adds Next-Of-Kin information to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by user.
     */
    public void addNok(String userLine) {
        String[] paramList = userLine.split(" [nkpear]/");
        assert paramList.length == 7 : "addnok input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        String nokName = paramList[INDEX_OF_NOK_NAME];
        String nokPhoneNumber = paramList[INDEX_OF_NOK_PHONE_NUMBER];
        String nokEmail = paramList[INDEX_OF_NOK_EMAIL];
        String nokAddress = paramList[INDEX_OF_NOK_ADDRESS];
        String nokRelationship = paramList[INDEX_OF_NOK_RELATIONSHIP];
        elderly.addNok(new NextOfKin(nokName, nokPhoneNumber, nokEmail, nokAddress, nokRelationship));
    }

    /**
     * Views the Next-Of_kin information of the elderly based on input.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewNok(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "Name is empty";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printNextOfKin(elderly);
    }

    /**
     * Prints the Next-Of-Kin information, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printNextOfKin(Elderly elderly) {
        System.out.println("Details of " + elderly.getName() + " Next-of-Kin are shown below:");
        System.out.println(elderly.getNextOfKin());
    }

    /**
     * Adds information to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by user.
     */
    public void addRecord(String userLine) {
        String[] paramList = userLine.split(" [npa]/");
        assert paramList.length == 4 : "addrec input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        String elderlyPhoneNumber = paramList[INDEX_OF_ELDERLY_PHONE_NUMBER];
        String elderlyAddress = paramList[INDEX_OF_ELDERLY_ADDRESS];
        elderly.addRecord(new Record(elderlyPhoneNumber, elderlyAddress));
        ui.printAddRecordMessage();
    }

    /**
     * Views the information of the elderly based on input.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewRecord(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "Name is empty";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printRecord(elderly);
    }

    /**
     * Prints the information, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printRecord(Elderly elderly) {
        System.out.println("Record of " + elderly.getName() + " is shown below:");
        System.out.println(elderly.getRecord());
    }

    /**
     * Gets the Elderly object given the name.
     *
     * @param name String containing name of elderly.
     * @return Elderly object.
     */
    public Elderly getElderly(String name) {
        int counter = 0;
        for (Elderly elderly : elderlyArrayList) {
            if (Objects.equals(elderly.getName(), name)) {
                break;
            }
            counter++;
        }
        return elderlyArrayList.get(counter);
    }

    /**
     * Views the blood pressure of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewBloodPressure(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "Name is empty";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printBloodPressure(elderly);
    }

    private void printBloodPressure(Elderly elderly) {
        double[] bloodPuressure = elderly.getBloodPressure();
        System.out.printf("Blood pressure of %s is now (%.2f %.2f)%n", elderly.getName(),
                bloodPuressure[0], bloodPuressure[1]);
    }

    /**
     * Sets the blood pressure of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void setBloodPressure(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 4 : "setbloodpressure input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        double systolicPressure = Double.parseDouble(paramList[INDEX_OF_SYSTOLIC_PRESSURE]);
        double diastolicPressure = Double.parseDouble(paramList[INDEX_OF_DIASTOLIC_PRESSURE]);
        Elderly elderly = getElderly(elderlyName);
        elderly.setBloodPressure(systolicPressure, diastolicPressure);
        ui.printSetBloodPressureMessage();
        printBloodPressure(elderly);
    }

    /**
     * Views the birthday of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewBirthday(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "Name is empty";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printBirthday(elderly);
    }

    private void printBirthday(Elderly elderly) {
        System.out.printf("Birthday of %s is %s%n", elderly.getName(), elderly.getBirthday());
    }

    /**
     * Sets the birthday of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void setBirthday(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 3 : "setbirthday input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        String birthday = paramList[INDEX_OF_BIRTHDAY];
        Elderly elderly = getElderly(elderlyName);
        elderly.setBirthday(birthday);
        ui.printSetBirthdayMessage();
        printBirthday(elderly);
    }

    /**
     * Sets the vaccination status of the elderly to be true.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void setVaccinated(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "setvaccinated input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        elderly.setVaccinated();
        ui.printSetVaccinationMessage();
        printVaccinationStatus(elderly);
    }

    /**
     * Gets the vaccination status of the elderly to be true.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void getVaccinationStatus(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "Name is empty";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printVaccinationStatus(elderly);
    }

    private void printVaccinationStatus(Elderly elderly) {
        boolean isVaccinated = elderly.isVaccinated();
        System.out.printf("%s is currently", elderly.getName());
        if (!isVaccinated) {
            System.out.printf("not ");
        }
        System.out.printf("vaccinated.%n");
    }

    /**
     * Get the number of elderly in the current list.
     */
    public int getElderlyCount() {
        return elderlyArrayList.size();
    }

    /**
     * Returns a consolidated String of all the elderly.
     * @return String containing all the elderly information in the system.
     */
    public String getConsolidatedStringOfElderly() {
        return elderlyArrayList
                .stream()
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
    }

    /**
     * Print current list of elderly along with number of elderly in system.
     */
    public void printElderly() {
        System.out.printf(NUMBER_OF_ELDERLY_STRING, getElderlyCount());
        ui.printElderlyList(getConsolidatedStringOfElderly());
    }

}
