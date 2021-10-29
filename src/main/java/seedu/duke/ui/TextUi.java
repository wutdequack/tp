package seedu.duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import seedu.duke.common.Elderly;
import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.InvalidInputException;

import static seedu.duke.common.MagicValues.INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY;
import static seedu.duke.common.MagicValues.INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY;
import static seedu.duke.common.Messages.ADD_NOK_MESSAGE;
import static seedu.duke.common.Messages.ADD_RECORD_MESSAGE;
import static seedu.duke.common.Messages.ADD_MEDICINE_MESSAGE;
import static seedu.duke.common.Messages.BYE_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.CLOSEST_SEARCH_RESULT_MESSAGE;
import static seedu.duke.common.Messages.ADD_MED_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.ADD_NOK_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.DELETE_ELDERLY_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.DELETE_ELDERLY_SUCCESSFUL_MESSAGE;
import static seedu.duke.common.Messages.ENTER_CONDITIONS_MESSAGE;
import static seedu.duke.common.Messages.ENTER_DOCTOR_MESSAGE;
import static seedu.duke.common.Messages.ENTER_NOTES_ON_CARE_MESSAGE;
import static seedu.duke.common.Messages.FILE_DOES_NOT_EXISTS_MESSAGE;
import static seedu.duke.common.Messages.FILE_EXISTS_MESSAGE;
import static seedu.duke.common.Messages.FILE_WRONG_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.HELP_MENU_INTRO_MESSAGE;
import static seedu.duke.common.Messages.INVALID_SEARCH_TERM_MESSAGE;
import static seedu.duke.common.Messages.LIST_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.VIEW_NOK_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.ADD_RECORD_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.VIEW_RECORD_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.VIEW_MED_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.ADD_APPOINTMENT_MESSAGE;
import static seedu.duke.common.Messages.ERROR_IN_DIET_INDEX_MESSAGE;
import static seedu.duke.common.Messages.ADD_APPOINTMENT_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.VIEW_APPOINTMENT_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.QUERY_RESULTS_INTRO_MESSAGE;
import static seedu.duke.common.Messages.WELCOME_MESSAGE;
import static seedu.duke.common.Messages.PROMPT_MESSAGE;
import static seedu.duke.common.Messages.LOGO;
import static seedu.duke.common.Messages.GOODBYE_MESSAGE;
import static seedu.duke.common.Messages.INVALID_COMMAND_MESSAGE;
import static seedu.duke.common.Messages.ADD_ELDERLY_MESSAGE;
import static seedu.duke.common.Messages.NO_SUCH_ELDERLY_MESSAGE;
import static seedu.duke.common.Messages.ADD_ELDERLY_FORMAT_MESSAGE;
import static seedu.duke.common.Messages.SET_VACCINATED_MESSAGE;
import static seedu.duke.common.Messages.SET_BIRTHDAY_MESSAGE;
import static seedu.duke.common.Messages.SET_BLOOD_PRESSURE_MESSAGE;
import static seedu.duke.common.Messages.SET_DIET_MESSAGE;
import static seedu.duke.common.Messages.ENTER_RISK_LEVEL_MESSAGE;
import static seedu.duke.common.Messages.ENTER_HOSPITAL_MESSAGE;
import static seedu.duke.common.Messages.SET_MEDICAL_HISTORY_MESSAGE;
import static seedu.duke.common.Messages.DELETE_MEDICAL_HISTORY_MESSAGE;

public class TextUi {
    private final Scanner in;
    private final PrintStream out;

    public TextUi() {
        this(System.in, System.out);
    }

    /**
     * Sets the default constructor for interaction with UI.
     *
     * @param in  A Scanner object.
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
     *
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
     * Prints to the screen asking for elderly risk level.
     */
    public void printEnterRiskLevelMessage() {
        out.println(ENTER_RISK_LEVEL_MESSAGE);
    }

    /**
     * Prints to the screen asking for hospital choice.
     */
    public void printEnterHospitalMessage() {
        out.println(ENTER_HOSPITAL_MESSAGE);
    }

    /**
     * Prints to the screen asking for conditions.
     */
    public void printEnterConditionsMessage() {
        out.println(ENTER_CONDITIONS_MESSAGE);
    }

    /**
     * Prints to the screen asking for notes on care.
     */
    public void printEnterNotesOnCareMessage() {
        out.println(ENTER_NOTES_ON_CARE_MESSAGE);
    }

    /**
     * Prints to the screen asking for doctor choice.
     */
    public void printEnterDoctorMessage() {
        out.println(ENTER_DOCTOR_MESSAGE);
    }


    /**
     * Prints Add Elderly message to user.
     */
    public void printAddElderlyMessage() {
        out.println(ADD_ELDERLY_MESSAGE);
    }

    /**
     * Prints that the elderly name given is not in system.
     */
    public void printNoSuchElderly() {
        out.println(NO_SUCH_ELDERLY_MESSAGE);
    }

    /**
     * Prints the correct format for addelderly.
     */
    public void printInvalidAddElderlyMessage() {
        out.println(ADD_ELDERLY_FORMAT_MESSAGE);
    }

    /**
     * Prints acknowledgement of appointment added to user.
     */
    public void printAddAppointmentMessage() {
        out.println(ADD_APPOINTMENT_MESSAGE);
    }

    /**
     * Prints correct format for viewappt.
     */
    public void printInvalidViewAppointmentMessage() {
        out.println(VIEW_APPOINTMENT_FORMAT_MESSAGE);
    }

    /**
     * Prints the correct format for addappt.
     */
    public void printInvalidAddAppointmentMessage() {
        out.println(ADD_APPOINTMENT_FORMAT_MESSAGE);
    }


    /**
     * Prints acknowledgement of medicine added to user.
     */
    public void printAddMedicineMessage() {
        out.println(ADD_MEDICINE_MESSAGE);
    }

    /**
     * Prints correct format for viewmed.
     */
    public void printInvalidViewMedicineMessage() {
        out.println(VIEW_MED_FORMAT_MESSAGE);
    }

    /**
     * Prints the correct format for addmed.
     */
    public void printInvalidAddMedicineMessage() {
        out.println(ADD_MED_FORMAT_MESSAGE);
    }

    /**
     * Prints acknowledgement of NOK added to user.
     */
    public void printAddNokMessage() {
        out.println(ADD_NOK_MESSAGE);
    }

    /**
     * Prints the correct format for addnok.
     */
    public void printInvalidAddNokMessage() {
        out.println(ADD_NOK_FORMAT_MESSAGE);
    }

    /**
     * Prints the correct format for viewnok.
     */
    public void printInvalidViewNokMessage() {
        out.println(VIEW_NOK_FORMAT_MESSAGE);
    }

    /**
     * Prints acknowledgement of record added to user.
     */
    public void printAddRecordMessage() {
        out.println(ADD_RECORD_MESSAGE);
    }

    /**
     * Prints the correct format for addrec.
     */
    public void printInvalidAddRecordMessage() {
        out.println(ADD_RECORD_FORMAT_MESSAGE);
    }

    /**
     * Prints the correct format for viewrec.
     */
    public void printInvalidViewRecordMessage() {
        out.println(VIEW_RECORD_FORMAT_MESSAGE);
    }

    /**
     * Prints acknowledgement of Vaccination status added to user.
     */
    public void printSetVaccinationMessage(Elderly elderly) {
        out.printf(SET_VACCINATED_MESSAGE, elderly.getName());
    }

    /**
     * Prints acknowledgement of birthday added to user.
     */
    public void printSetBirthdayMessage(Elderly elderly) {
        out.printf(SET_BIRTHDAY_MESSAGE, elderly.getName(), elderly.getBirthday());
    }

    /**
     * Prints acknowledgement of blood pressure added to user.
     */
    public void printSetBloodPressureMessage(Elderly elderly) {
        out.printf(SET_BLOOD_PRESSURE_MESSAGE, elderly.getName(),
                elderly.getBloodPressure()[INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY],
                elderly.getBloodPressure()[INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY]);
    }

    /**
     * Prints the list of elderly given a consolidated list of elderly.
     *
     * @param elderlyListString A string containing a consolidated list of elderly.
     */
    public void printElderlyList(String elderlyListString) {
        out.println(elderlyListString);
    }

    /**
     * Prints acknowledgement of dietary preference of elderly added to user.
     */
    public void printSetDietMessage(Elderly elderly) {
        out.printf(SET_DIET_MESSAGE, elderly.getName(), elderly.getDiet());
    }

    /**
     * Prints acknowledgement of the medical history of the elderly is updated.
     */
    public void printAddMedicalHistoryMessage(Elderly elderly) {
        out.printf(SET_MEDICAL_HISTORY_MESSAGE, elderly.getName());
    }

    /**
     * Prints acknowledgement of the medical history of the elderly is updated.
     */
    public void printDeleteMedicalHistoryMessage(Elderly elderly) {
        out.printf(DELETE_MEDICAL_HISTORY_MESSAGE, elderly.getName());
    }

    /**
     * Prints the error message of the caught Duke exception.
     */
    public void printDukeException(DukeException dukeException) {
        out.println(dukeException.getMessage());
    }

    /**
     * Prints the error message of the caught invalid input exception.
     */
    public void printInvalidInputException(InvalidInputException invalidInputException) {
        out.println("Invalid input detected " + invalidInputException.getMessage());
    }

    /**
     * Prints the error message of the caught general exception.
     */
    public void printGeneralException(Exception exception) {
        out.println(exception.getMessage());
    }

    /**
     * Prints intro message for query results.
     *
     * @param searchTerm String containing medicine query by user.
     */
    public void printQueryResultsIntroString(String searchTerm) {
        out.println(String.format(QUERY_RESULTS_INTRO_MESSAGE, searchTerm));
    }

    /**
     * Prints the help menu with relevant syntax.
     */
    public void printHelpMenu() {
        out.println();
        out.println(String.join(System.lineSeparator(),
                HELP_MENU_INTRO_MESSAGE,
                ADD_ELDERLY_FORMAT_MESSAGE,
                ADD_MED_FORMAT_MESSAGE,
                VIEW_MED_FORMAT_MESSAGE,
                ADD_APPOINTMENT_FORMAT_MESSAGE,
                VIEW_APPOINTMENT_FORMAT_MESSAGE,
                ADD_NOK_FORMAT_MESSAGE,
                VIEW_NOK_FORMAT_MESSAGE,
                ADD_RECORD_FORMAT_MESSAGE,
                VIEW_RECORD_FORMAT_MESSAGE,
                DELETE_ELDERLY_FORMAT_MESSAGE,
                LIST_FORMAT_MESSAGE,
                BYE_FORMAT_MESSAGE
        ));
    }

    /**
     * Print the closest match to what the user query.
     *
     * @param closestMatch String containing closest match.
     */
    public void printClosestMatch(String closestMatch) {
        out.printf(CLOSEST_SEARCH_RESULT_MESSAGE, closestMatch);
    }

    /**
     * Print that you don't know what the user is querying for.
     *
     * @param searchTerm String containing search Term.
     */
    public void printCannotFindQuery(String searchTerm) {
        out.printf(INVALID_SEARCH_TERM_MESSAGE, searchTerm);
    }

    /**
     * Print that you have deleted from the arrayList.
     *
     * @param searchTerm String containing search Term.
     */
    public void printDeleteByName(String searchTerm) {
        out.printf(DELETE_ELDERLY_SUCCESSFUL_MESSAGE, searchTerm);
    }

    /**
     * Prints exception message.
     *
     * @param e Exception that has been thrown
     */
    public void printExceptionMessage(Exception e) {
        out.println(e.getMessage());
    }

    /**
     * Prints that the given file path exists.
     *
     * @param newFilePath String containing the filepath.
     */
    public void printFileExists(String newFilePath) {
        out.printf(FILE_EXISTS_MESSAGE, newFilePath);
    }

    /**
     * Prints that the given file path does not exist.
     *
     * @param newFilePath String containing the new filepath.
     */
    public void printFileDoesNotExists(String newFilePath) {
        out.printf(FILE_DOES_NOT_EXISTS_MESSAGE, newFilePath);
    }

    /**
     * Prints that the file is in the wrong file format.
     */
    public void printWrongFileSyntax() {
        out.println(FILE_WRONG_FORMAT_MESSAGE);
    }
}
