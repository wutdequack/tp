package seedu.duke;

import static seedu.duke.common.MagicValues.ADD_APPOINTMENT;
import static seedu.duke.common.MagicValues.ADD_ELDERLY;
import static seedu.duke.common.MagicValues.ADD_MEDICINE;
import static seedu.duke.common.MagicValues.BYE_STRING;
import static seedu.duke.common.MagicValues.VIEW_APPOINTMENT;
import static seedu.duke.common.MagicValues.VIEW_MEDICINE;
import static seedu.duke.common.MagicValues.elderlyArrayList;
import static seedu.duke.common.MagicValues.INDEX_OF_DATE;
import static seedu.duke.common.MagicValues.INDEX_OF_ELDERLY_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_LOCATION;
import static seedu.duke.common.MagicValues.INDEX_OF_MEDICINE_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_FREQUENCY;
import static seedu.duke.common.MagicValues.INDEX_OF_PURPOSE;
import static seedu.duke.common.MagicValues.INDEX_OF_TIME;
import static seedu.duke.common.MagicValues.LENGTH_IF_PURPOSE_EXISTS;

import java.util.Objects;
import seedu.duke.common.Elderly;
import seedu.duke.common.Appointment;
import seedu.duke.common.Medicine;
import seedu.duke.ui.TextUi;
import seedu.duke.parser.Parser;


public class Duke {

    /**
     * Global variable used to show if loop to get user input should continue running.
     */
    public static Boolean toContinue = true;

    private TextUi ui;

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * Handles the running of the program.
     */
    private void run() {
        start();
        loopUntilByeInitiated();
    }

    /**
     * Set up objects and prints Welcome Message.
     */
    private void start() {
        ui = new TextUi();
        ui.printWelcomeMessage();
    }

    /**
     * Continues running until bye command is issued.
     */
    private void loopUntilByeInitiated() {
        // Continue Running Loop until bye is called
        while (toContinue) {
            // Gets user input
            String userInput = ui.getUserInput();
            executeCommand(userInput);
        }
    }

    /**
     * Stops loop and print bye message.
     */
    public void handleByeSequence() {
        toContinue = false;
        ui.printGoodByeMessage();
    }

    /**
     * Executes the command based on what is given by the user.
     *
     * @param userLine Line that is inputted by the user.
     */
    private void executeCommand(String userLine) {
        String keyword = new Parser().getKeywordFromUserInput(userLine);

        // Checks for the input for keywords
        switch (keyword.toUpperCase()) {
        case BYE_STRING:
            // Stop loop and print Goodbye
            handleByeSequence();
            break;
        case ADD_MEDICINE:
            addMedicine(userLine);
            break;
        case VIEW_MEDICINE:
            viewMedicine(userLine);
            break;
        case ADD_APPOINTMENT:
            addAppointment(userLine);
            break;
        case VIEW_APPOINTMENT:
            viewAppointment(userLine);
            break;
        case ADD_ELDERLY:
            addElderly(userLine);
            break;
        default:
            // Command is not recognized
            ui.printUnknownCommandMessage();
            break;
        }

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
