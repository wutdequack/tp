package seedu.duke.common;

import seedu.duke.list.HospitalList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.TextUi;

import seedu.duke.regex.RegexChecker;

public class MagicValues {
    /**
     * Keywords for commands.
     */
    public static final String BYE_STRING = "BYE";
    public static final String LIST_ELDERLY = "LIST";
    public static final String ADD_MEDICINE = "ADDMED";
    public static final String VIEW_MEDICINE = "VIEWMED";
    public static final String GENERAL_CHECKUP = "general checkup";
    public static final String ADD_APPOINTMENT = "ADDAPPT";
    public static final String VIEW_APPOINTMENT = "VIEWAPPT";
    public static final String ADD_ELDERLY = "ADDELDERLY";
    public static final String ADD_NOK = "ADDNOK";
    public static final String VIEW_NOK = "VIEWNOK";
    public static final String ADD_RECORD = "ADDREC";
    public static final String VIEW_RECORD = "VIEWREC";
    public static final String SET_BIRTHDAY = "SETBIRTHDAY";
    public static final String VIEW_BIRTHDAY = "VIEWBIRTHDAY";
    public static final String SET_BLOOD_PRESSURE = "SETBLOODPRESSURE";
    public static final String VIEW_BLOOD_PRESSURE = "VIEWBLOODPRESSURE";
    public static final String SET_VACCINATED = "SETVACCINATED";
    public static final String VIEW_VACCINATION = "VIEWVACCINATION";
    public static final String UPDATE_VACCINATATION_STATUS = "UPDATEVACCINATIONSTATUS";
    public static final String SET_DIET = "SETDIET";
    public static final String VIEW_DIET = "VIEWDIET";
    public static final String FIND_BY_MED = "FINDBYMED";
    public static final String FIND_BY_DIET = "FINDBYDIET";
    public static final String FIND_BY_NAME = "FINDBYNAME";
    public static final String GET_HELP_MENU = "HELP";
    public static final String DELETE_ELDERLY = "DELETEELDERLY";
    public static final String LOW = "L";
    public static final String MEDIUM = "M";
    public static final String HIGH = "H";


    /**
     * List of constants used in tokenizing user input.
     */
    public static final int INDEX_OF_KEYWORD = 0;
    public static final int INDEX_OF_ELDERLY_USERNAME = 1;
    public static final int INDEX_OF_ELDERLY_NAME = 2;
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
    public static final int INDEX_OF_SYSTOLIC_PRESSURE = 2;
    public static final int INDEX_OF_DIASTOLIC_PRESSURE = 3;
    public static final int INDEX_OF_BIRTHDAY = 2;
    public static final int LENGTH_OF_BLOOS_PRESSURE_ARRAY = 2;
    public static final int INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY = 0;
    public static final int INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY = 1;
    public static final int INDEX_OF_SEARCH_MED = 1;
    public static final int INDEX_OF_SEARCH_DIET = 1;
    public static final int INDEX_OF_SEARCH_NAME = 1;
    public static final int INDEX_OF_USER_NAME = 1;

    public static final String NAME_SPLIT = " [un]/";
    public static final String ADD_MEDICINE_SPLIT = " [nmf]/";
    public static final String ADD_APPOINTMENT_SPLIT = " [nldtp]/";
    public static final String ADD_NOK_SPLIT = " [nkpear]/";
    public static final String ADD_RECORD_SPLIT = " [npa]/";
    public static final String SEARCH_MED_SPLIT = " m/";
    public static final String SEARCH_DIET_SPLIT = " d/";
    public static final String SEARCH_NAME_SPLIT = " n/";
    public static final String DELETE_NAME_SPLIT = " u/";

    public static TextUi ui = new TextUi();
    public static RegexChecker re = new RegexChecker();
    public static Parser parser = new Parser();
    public static HospitalList hospitalArrayList = new HospitalList();
}
