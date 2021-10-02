package seedu.duke;

import static seedu.duke.common.MagicValues.BYE_STRING;

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
        default:
            // Command is not recognized
            ui.printUnknownCommandMessage();
            break;
        }

    }

}
