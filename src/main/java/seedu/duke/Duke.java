package seedu.duke;


import java.util.ArrayList;
import java.util.Objects;

import seedu.duke.common.Elderly;
import seedu.duke.common.Appointment;
import seedu.duke.common.Medicine;
import seedu.duke.list.ElderlyList;
import seedu.duke.ui.TextUi;
import seedu.duke.parser.Parser;

import static seedu.duke.common.MagicValues.LIST_ELDERLY;
import static seedu.duke.common.MagicValues.ui;
import static seedu.duke.common.MagicValues.ADD_APPOINTMENT;
import static seedu.duke.common.MagicValues.ADD_ELDERLY;
import static seedu.duke.common.MagicValues.ADD_MEDICINE;
import static seedu.duke.common.MagicValues.BYE_STRING;
import static seedu.duke.common.MagicValues.VIEW_APPOINTMENT;
import static seedu.duke.common.MagicValues.VIEW_MEDICINE;
import static seedu.duke.common.MagicValues.INDEX_OF_DATE;
import static seedu.duke.common.MagicValues.INDEX_OF_ELDERLY_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_LOCATION;
import static seedu.duke.common.MagicValues.INDEX_OF_MEDICINE_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_FREQUENCY;
import static seedu.duke.common.MagicValues.INDEX_OF_PURPOSE;
import static seedu.duke.common.MagicValues.INDEX_OF_TIME;
import static seedu.duke.common.MagicValues.LENGTH_IF_PURPOSE_EXISTS;
import static seedu.duke.common.MagicValues.ADD_NOK;
import static seedu.duke.common.MagicValues.ADD_RECORD;
import static seedu.duke.common.MagicValues.VIEW_NOK;
import static seedu.duke.common.MagicValues.VIEW_RECORD;
import static seedu.duke.common.MagicValues.VIEW_BLOOD_PRESSURE;
import static seedu.duke.common.MagicValues.SET_BLOOD_PRESSURE;
import static seedu.duke.common.MagicValues.VIEW_BIRTHDAY;
import static seedu.duke.common.MagicValues.SET_BIRTHDAY;
import static seedu.duke.common.MagicValues.SET_VACCINATED;
import static seedu.duke.common.MagicValues.VIEW_VACCINATION;


public class Duke {

    /**
     * Global variable used to show if loop to get user input should continue running.
     */
    public static Boolean toContinue = true;

    private ElderlyList elderlyHelperFunction;

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
        elderlyHelperFunction = new ElderlyList();
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
            elderlyHelperFunction.addMedicine(userLine);
            ui.printAddMedicineMessage();
            break;
        case VIEW_MEDICINE:
            elderlyHelperFunction.viewMedicine(userLine);
            break;
        case ADD_APPOINTMENT:
            elderlyHelperFunction.addAppointment(userLine);
            ui.printAddAppointmentMessage();

            break;
        case VIEW_APPOINTMENT:
            elderlyHelperFunction.viewAppointment(userLine);
            break;
        case ADD_ELDERLY:
            elderlyHelperFunction.addElderly(userLine);
            ui.printAddElderlyMessage();
            break;
        case ADD_NOK:
            elderlyHelperFunction.addNok(userLine);
            break;
        case VIEW_NOK:
            elderlyHelperFunction.viewNok(userLine);
            break;
        case ADD_RECORD:
            elderlyHelperFunction.addRecord(userLine);
            break;
        case VIEW_RECORD:
            elderlyHelperFunction.viewRecord(userLine);
            break;
        case VIEW_BLOOD_PRESSURE:
            elderlyHelperFunction.viewBloodPressure(userLine);
            break;
        case SET_BLOOD_PRESSURE:
            elderlyHelperFunction.setBloodPressure(userLine);
            break;
        case VIEW_BIRTHDAY:
            elderlyHelperFunction.viewBirthday(userLine);
            break;
        case SET_BIRTHDAY:
            elderlyHelperFunction.setBirthday(userLine);
            break;
        case SET_VACCINATED:
            elderlyHelperFunction.setVaccinated(userLine);
            break;
        case VIEW_VACCINATION:
            elderlyHelperFunction.getVaccinationStatus(userLine);
            break;
        case LIST_ELDERLY:
            elderlyHelperFunction.printElderly();
            break;
        default:
            // Command is not recognized
            ui.printUnknownCommandMessage();
            break;
        }

    }

}
