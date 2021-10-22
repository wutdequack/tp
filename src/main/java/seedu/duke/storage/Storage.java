package seedu.duke.storage;

import static seedu.duke.common.MagicValues.INDEX_OF_FILE_PATH;
import static seedu.duke.common.MagicValues.STORE_FILE_SPLIT;
import static seedu.duke.common.MagicValues.re;
import static seedu.duke.common.MagicValues.ui;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import com.google.gson.GsonBuilder;
import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.InvalidStoreToFilePathException;
import seedu.duke.list.ElderlyList;

public class Storage {

    private ElderlyList elderlyList;
    private String filePath;
    private Gson gson;

    public Storage(String filePath, ElderlyList elderlyList) {
        this.filePath = filePath;
        this.elderlyList = elderlyList;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Generates the string based on the elderly array list to be stored.
     * @return String containing all the information to be stored.
     */
    public String generateStringToBeStored() {
        return gson.toJsonTree(elderlyList.getElderlyArrayList()).toString();
    }

    /**
     * Store program's data as JSON into a file using given filepath.
     * @param userLine String containing store command and filepath.
     */
    public void storeFromFilePath(String userLine) {
        try {
            // Checks if the command is issued correctly
            if (!re.isValidStoreFileFromFilePath(userLine)) {
                throw new InvalidStoreToFilePathException();
            }

            String[] paramList = userLine.split(STORE_FILE_SPLIT);
            String filePath = paramList[INDEX_OF_FILE_PATH];

            // Convert class to json
            String toWrite = generateStringToBeStored();

            // Writes to file path and overwrites all contents if it doesn't exist
            FileWriter fw = new FileWriter(this.filePath);
            JsonWriter jw = gson.newJsonWriter(fw);
            // This doesn't overwrite
            gson.toJson(gson.toJsonTree(elderlyList.getElderlyArrayList()), jw);
            fw.write(toWrite);
            fw.close();
        } catch (DukeException | IOException e) {
            ui.printExceptionMessage(e);
        }
    }
}
