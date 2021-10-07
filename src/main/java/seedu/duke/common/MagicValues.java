package seedu.duke.common;

import java.util.ArrayList;
import seedu.duke.ui.TextUi;

public class MagicValues {
    /**
     * Keywords for commands.
     */
    public static final String BYE_STRING = "BYE";
    public static final String ADD_MEDICINE = "ADDMED";
    public static final String ADD_APPOINTMENT = "ADDAPPT";
    public static final String VIEW_MEDICINE = "VIEWMED";
    public static final String VIEW_APPOINTMENT = "VIEWAPPT";
    public static final String ADD_ELDERLY = "ADDELDERLY";
    public static final String ADD_NOK = "ADDNOK";
    public static final String VIEW_NOK = "VIEWNOK";
    public static final String ADD_RECORD = "ADDREC";
    public static final String VIEW_RECORD = "VIEWREC";


    /**
     * List of constants used in tokenizing user input.
     */
    public static final int INDEX_OF_KEYWORD = 0;
    public static final int INDEX_OF_ELDERLY_NAME = 1;
    public static final int INDEX_OF_LOCATION = 2;
    public static final int INDEX_OF_MEDICINE_NAME = 2;
    public static final int INDEX_OF_NOK_NAME = 2;
    public static final int INDEX_OF_ELDERLY_PHONE_NUMBER = 2;
    public static final int INDEX_OF_DATE = 3;
    public static final int INDEX_OF_FREQUENCY = 3;
    public static final int INDEX_OF_NOK_PHONE_NUMBER = 3;
    public static final int INDEX_OF_ELDERLY_ADDRESS = 3;
    public static final int INDEX_OF_NOK_EMAIL = 4;
    public static final int INDEX_OF_TIME = 4;
    public static final int INDEX_OF_PURPOSE = 5;
    public static final int INDEX_OF_NOK_ADDRESS = 5;
    public static final int INDEX_OF_NOK_RELATIONSHIP = 6;
    public static final int LENGTH_IF_PURPOSE_EXISTS = 6;



    /**
     * Elderly arraylist.
     */
    public static ArrayList<Elderly> elderlyArrayList;
    public static TextUi ui;
}
