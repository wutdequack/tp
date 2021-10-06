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
import static seedu.duke.common.MagicValues.ui;

import java.util.ArrayList;
import java.util.Objects;
import seedu.duke.common.Elderly;
import seedu.duke.common.Appointment;
import seedu.duke.common.Medicine;
import seedu.duke.list.ElderlyList;
import seedu.duke.ui.TextUi;
import seedu.duke.parser.Parser;


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
        default:
            // Command is not recognized
            ui.printUnknownCommandMessage();
            break;
        }

    }

}
