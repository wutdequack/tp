package seedu.duke;


import java.util.ArrayList;
import java.util.Objects;
import seedu.duke.common.Elderly;
import seedu.duke.common.Appointment;
import seedu.duke.common.Medicine;
import seedu.duke.list.ElderlyList;
import seedu.duke.ui.TextUi;
import seedu.duke.parser.Parser;

import static seedu.duke.common.MagicValues.*;


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
        elderlyArrayList = new ArrayList<Elderly>();
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
        case SET_BLOOD_PRESSURE:
            elderlyHelperFunction.setBloodPressure(userLine);
        case VIEW_BIRTHDAY:
            elderlyHelperFunction.viewBirthday(userLine);
        case SET_BIRTHDAY:
            elderlyHelperFunction.setBirthday(userLine);
        case SET_VACCINATED:
            elderlyHelperFunction.setVaccinated(userLine);
        case VIEW_VACCINATION:
            elderlyHelperFunction.getVaccinationStatus(userLine);

        default:
            // Command is not recognized
            ui.printUnknownCommandMessage();
            break;
        }

    }

}
