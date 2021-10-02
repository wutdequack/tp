package seedu.duke.common;

/**
 * Class containing hardcoded Strings.
 */
public class Messages {

    /**
     * Used in the printing of Welcome Message.
     */
    public final static String LOGO = " ____ ____ ____ ____ ____ ____ ____ \n"
            + "||E |||l |||d |||e |||r |||l |||y ||\n"
            + "||__|||__|||__|||__|||__|||__|||__||\n"
            + "|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|/__\\|\n"
            + " ____ ____                          \n"
            + "||I |||n ||                         \n"
            + "||__|||__||                         \n"
            + "|/__\\|/__\\|                         \n"
            + " ____ ____ ____ ____                \n"
            + "||Y |||o |||u |||r ||               \n"
            + "||__|||__|||__|||__||               \n"
            + "|/__\\|/__\\|/__\\|/__\\|               \n"
            + " ____ ____ ____ ____                \n"
            + "||H |||o |||o |||d ||               \n"
            + "||__|||__|||__|||__||               \n"
            + "|/__\\|/__\\|/__\\|/__\\|               ";
    public final static String WELCOME_MESSAGE = "Welcome admin. Type after the '>' to start.";

    /**
     * Used to prompt user to type in commands.
     */
    public final static String PROMPT_MESSAGE = "> ";

    /**
     * Used to respond to user when command is unrecognized.
     */
    public final static String INVALID_COMMAND_MESSAGE = "Sorry user, I do not recognize this command";

    /**
     * Used when exiting the application when the bye command is issued.
     */
    public final static String GOODBYE_MESSAGE = "Bye command has been recognized. Goodbye!";

}
