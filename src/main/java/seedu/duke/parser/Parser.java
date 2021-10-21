package seedu.duke.parser;

import java.util.Scanner;

import static seedu.duke.common.MagicValues.INDEX_OF_KEYWORD;
import static seedu.duke.common.MagicValues.INDEX_OF_SEARCH_DIET;
import static seedu.duke.common.MagicValues.INDEX_OF_SEARCH_MED;
import static seedu.duke.common.MagicValues.SEARCH_DIET_SPLIT;
import static seedu.duke.common.MagicValues.SEARCH_MED_SPLIT;

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
     * Extracts user's choice from user input.
     *
     * @return the choice the user keyed in
     */
    public static int parseChoiceFromUserInput() {
        int choice;
        try (Scanner sc = new Scanner(System.in)) {
            choice = Integer.parseInt(sc.nextLine());
        }
        return choice;
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
}
