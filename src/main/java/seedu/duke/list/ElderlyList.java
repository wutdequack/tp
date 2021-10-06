package seedu.duke.list;

import static seedu.duke.common.MagicValues.INDEX_OF_DATE;
import static seedu.duke.common.MagicValues.INDEX_OF_ELDERLY_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_FREQUENCY;
import static seedu.duke.common.MagicValues.INDEX_OF_LOCATION;
import static seedu.duke.common.MagicValues.INDEX_OF_MEDICINE_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_PURPOSE;
import static seedu.duke.common.MagicValues.INDEX_OF_TIME;
import static seedu.duke.common.MagicValues.LENGTH_IF_PURPOSE_EXISTS;
import static seedu.duke.common.MagicValues.elderlyArrayList;
import static seedu.duke.common.MagicValues.ui;

import java.util.Objects;
import seedu.duke.common.Appointment;
import seedu.duke.common.Elderly;
import seedu.duke.common.Medicine;

public class ElderlyList {

    public ElderlyList() {
    }

    /**
     * Adds the elderly into the elderly array list.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addElderly(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[1];
        elderlyArrayList.add(new Elderly(elderlyName));
        ui.printAddElderlyMessage();
    }

    /**
     * Adds the medicine to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addMedicine(String userLine) {
        String[] paramList = userLine.split(" [nmf]/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        String medicineName = paramList[INDEX_OF_MEDICINE_NAME];
        String frequency = paramList[INDEX_OF_FREQUENCY];
        elderly.addMedicine(new Medicine(medicineName, frequency));
        ui.printAddMedicineMessage();
    }

    /**
     * Views all medicine the elderly needs to take based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void viewMedicine(String userLine) {
        String[] paramList = userLine.split(" n/");
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
        ui.printAddAppointmentMessage();
    }

    /**
     * Views all appointments the elderly needs to take based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void viewAppointment(String userLine) {
        String[] paramList = userLine.split(" n/");
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

}
