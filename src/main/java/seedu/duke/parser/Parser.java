package seedu.duke.parser;

import static seedu.duke.common.MagicValues.INDEX_OF_KEYWORD;

public class Parser {

    public Parser() {
    }

    /**
     * Extracts keyword from user input.
     * @param userLine Line that is inputted by the user.
     * @return String containing the keyword.
     */
    public String getKeywordFromUserInput(String userLine) {
        return userLine.split(" ")[INDEX_OF_KEYWORD];
    }

}
