package seedu.duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static seedu.duke.common.Messages.ADD_NOK_MESSAGE;
import static seedu.duke.common.Messages.ADD_RECORD_MESSAGE;
import static seedu.duke.common.Messages.ADD_MEDICINE_MESSAGE;
import static seedu.duke.common.Messages.ADD_APPOINTMENT_MESSAGE;
import static seedu.duke.common.Messages.WELCOME_MESSAGE;
import static seedu.duke.common.Messages.PROMPT_MESSAGE;
import static seedu.duke.common.Messages.LOGO;
import static seedu.duke.common.Messages.GOODBYE_MESSAGE;
import static seedu.duke.common.Messages.INVALID_COMMAND_MESSAGE;
import static seedu.duke.common.Messages.ADD_ELDERLY_MESSAGE;

public class TextUi {
    private final Scanner in;
    private final PrintStream out;

    public TextUi() {
        this(System.in, System.out);
    }

    /**
     * Sets the default constructor for interaction with UI.
     * @param in A Scanner object.
     * @param out A PrintStream object.
     */
    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Prints the welcome message to the user.
     */
    public void printWelcomeMessage() {
        out.println(LOGO);
        out.println(WELCOME_MESSAGE);
    }

    /**
     * Prompts the user for input and returns the received input.
     * @return Line entered by the user.
     */
    public String getUserInput() {
        out.print(PROMPT_MESSAGE);
        String input = in.nextLine();
        // Keep getting input until its not empty
        while (input.trim().isEmpty()) {
            input = in.nextLine();
        }
        return input;
    }

    /**
     * Prints Goodbye message to user.
     */
    public void printGoodByeMessage() {
        out.println(GOODBYE_MESSAGE);
    }

    /**
     * Prints to the screen that you don't understand the commands.
     */
    public void printUnknownCommandMessage() {
        out.println(INVALID_COMMAND_MESSAGE);
    }

    /**
     * Prints Goodbye message to user.
     */
    public void printAddElderlyMessage() {
        out.println(ADD_ELDERLY_MESSAGE);
    }

    /**
     * Prints Goodbye message to user.
     */
    public void printAddAppointmentMessage() {
        out.println(ADD_APPOINTMENT_MESSAGE);
    }

    /**
     * Prints Goodbye message to user.
     */
    public void printAddMedicineMessage() {
        out.println(ADD_MEDICINE_MESSAGE);
    }

    public void printAddNokMessage() {
        out.println(ADD_NOK_MESSAGE);
    }

    public void printAddRecordMessage() {
        out.println(ADD_RECORD_MESSAGE);
    }
}
