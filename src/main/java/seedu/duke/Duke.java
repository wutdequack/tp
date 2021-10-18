package seedu.duke;


import seedu.duke.common.Elderly;
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
import static seedu.duke.common.MagicValues.SET_DIET;
import static seedu.duke.common.MagicValues.VIEW_DIET;


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
    public void terminateInput() {
        toContinue = false;
    }

    /**
     * Executes the command based on what is given by the user.
     *
     * @param userLine Line that is inputted by the user.
     */
    private void executeCommand(String userLine) {
        String keyword = new Parser().getKeywordFromUserInput(userLine);
        Elderly targetElderly;

        // Checks for the input for keywords
        switch (keyword.toUpperCase()) {
        case BYE_STRING:
            // Stop loop and print Goodbye
            terminateInput();
            ui.printGoodByeMessage();
            break;
        case ADD_MEDICINE:
            elderlyHelperFunction.addMedicine(userLine);
            break;
        case VIEW_MEDICINE:
            elderlyHelperFunction.viewMedicine(userLine);
            break;
        case ADD_APPOINTMENT:
            elderlyHelperFunction.addAppointment(userLine);
            break;
        case VIEW_APPOINTMENT:
            elderlyHelperFunction.viewAppointment(userLine);
            break;
        case ADD_ELDERLY:
            elderlyHelperFunction.addElderly(userLine);
            break;
        case ADD_NOK:
            elderlyHelperFunction.addNok(userLine);
            ui.printAddNokMessage();
            break;
        case VIEW_NOK:
            elderlyHelperFunction.viewNok(userLine);
            break;
        case ADD_RECORD:
            elderlyHelperFunction.addRecord(userLine);
            ui.printAddRecordMessage();
            break;
        case VIEW_RECORD:
            elderlyHelperFunction.viewRecord(userLine);
            break;
        case VIEW_BLOOD_PRESSURE:
            elderlyHelperFunction.viewBloodPressure(userLine);
            break;
        case SET_BLOOD_PRESSURE:
            //targetElderly = elderlyHelperFunction.setBloodPressure(userLine);
            //ui.printSetBloodPressureMessage(targetElderly);
            break;
        case VIEW_BIRTHDAY:
            elderlyHelperFunction.viewBirthday(userLine);
            break;
        case SET_BIRTHDAY:
            //targetElderly = elderlyHelperFunction.setBirthday(userLine);
            //ui.printSetBirthdayMessage(targetElderly);
            break;
        case SET_VACCINATED:
            //targetElderly = elderlyHelperFunction.setVaccinated(userLine);
            //ui.printSetVaccinationMessage(targetElderly);
            break;
        case VIEW_VACCINATION:
            elderlyHelperFunction.getVaccinationStatus(userLine);
            break;
        case LIST_ELDERLY:
            elderlyHelperFunction.printElderly();
            break;
        case SET_DIET:
            //targetElderly = elderlyHelperFunction.setDietaryPreference(userLine);
            //ui.printSetDietMessage(targetElderly);
            break;
        case VIEW_DIET:
            elderlyHelperFunction.viewDietaryPreference(userLine);
            break;

        default:
            // Command is not recognized
            // assert keyword.equals("a") : "Nothing has been input";
            ui.printUnknownCommandMessage();
            break;
        }

    }

}
