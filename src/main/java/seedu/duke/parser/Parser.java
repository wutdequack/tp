package seedu.duke.parser;

import java.util.Scanner;

import static seedu.duke.common.MagicValues.DELETE_NAME_SPLIT;
import static seedu.duke.common.MagicValues.INDEX_OF_KEYWORD;
import static seedu.duke.common.MagicValues.INDEX_OF_SEARCH_DIET;
import static seedu.duke.common.MagicValues.INDEX_OF_SEARCH_MED;
import static seedu.duke.common.MagicValues.INDEX_OF_SEARCH_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_USER_NAME;
import static seedu.duke.common.MagicValues.SEARCH_DIET_SPLIT;
import static seedu.duke.common.MagicValues.SEARCH_MED_SPLIT;
import static seedu.duke.common.MagicValues.SEARCH_NAME_SPLIT;

public class Parser {

    public Parser() {
    }

    /**
     * Extracts keyword from user input.
     *
     * @param userLine Line that is inputted by the user.
     * @return String containing the keyword.
     */
    public String getKeywordFromUserInput(String userLine) {
        return userLine.split(" ")[INDEX_OF_KEYWORD];
    }

    /**
     * Gets medicine name from findbymed query.
     * @param userLine String containing command findbymed and search term.
     * @return String containing medicine name.
     */
    public String getMedicineFromSearchMed(String userLine) {
        // Extract out medicine name
        String[] paramList = userLine.split(SEARCH_MED_SPLIT);
        assert paramList.length == 2 : "findbymed input does not have all required values";
        return paramList[INDEX_OF_SEARCH_MED];
    }

    /**
     * Gets diet preference from findbydiet query.
     * @param userLine String containing command findbydiet and search term.
     * @return String containing diet preference.
     */
    public String getDietFromSearchMed(String userLine) {
        // Extract out diet name
        String[] paramList = userLine.split(SEARCH_DIET_SPLIT);
        assert paramList.length == 2 : "findbydiet input does not have all required values";
        return paramList[INDEX_OF_SEARCH_DIET];
    }

    /**
     * Gets real name from findbyname query.
     * @param userLine String containing command findbyname and search term.
     * @return String containing real name.
     */
    public String getRealNameFromSearchName(String userLine) {
        // Extract out Real name
        String[] paramList = userLine.split(SEARCH_NAME_SPLIT);
        assert paramList.length == 2 : "findbyname input does not have all required values";
        return paramList[INDEX_OF_SEARCH_NAME];
    }

    /**
     * Gets username from deleteelderly query.
     * @param userLine String containing command deleteelderly and search term.
     * @return String containing username.
     */
    public String getUserNameFromDeleteElderly(String userLine) {
        // Extract out username
        String[] paramList = userLine.split(DELETE_NAME_SPLIT);
        assert paramList.length == 2 : "deleteelderly input does not have all required values";
        return paramList[INDEX_OF_USER_NAME];
    }
}
