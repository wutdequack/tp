package seedu.duke.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;
import seedu.duke.common.Elderly;
import seedu.duke.common.Medicine;
import seedu.duke.common.Appointment;
import seedu.duke.common.NextOfKin;
import seedu.duke.common.Record;

import seedu.duke.exceptions.DukeException;
import seedu.duke.exceptions.ElderlyNotFoundException;
import seedu.duke.exceptions.InvalidDeleteElderlyException;
import seedu.duke.exceptions.InvalidNokFormatException;
import seedu.duke.exceptions.InvalidMedicineException;
import seedu.duke.exceptions.InvalidAppointmentFormatException;
import seedu.duke.exceptions.InvalidElderlyRecordFormatException;

import java.util.Objects;
import java.util.Optional;
import seedu.duke.exceptions.InvalidViewByNameException;
import seedu.duke.exceptions.InvalidViewDietException;
import seedu.duke.exceptions.InvalidViewMedicineException;

import static seedu.duke.common.MagicValues.ADD_NOK_SPLIT;
import static seedu.duke.common.MagicValues.ADD_RECORD_SPLIT;
import static seedu.duke.common.MagicValues.INDEX_OF_ELDERLY_USERNAME;
import static seedu.duke.common.MagicValues.NAME_SPLIT;
import static seedu.duke.common.MagicValues.ADD_MEDICINE_SPLIT;
import static seedu.duke.common.MagicValues.ADD_APPOINTMENT_SPLIT;
import static seedu.duke.common.MagicValues.INDEX_OF_DATE;
import static seedu.duke.common.MagicValues.INDEX_OF_ELDERLY_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_ELDERLY_ADDRESS;
import static seedu.duke.common.MagicValues.INDEX_OF_FREQUENCY;
import static seedu.duke.common.MagicValues.INDEX_OF_LOCATION;
import static seedu.duke.common.MagicValues.INDEX_OF_ELDERLY_PHONE_NUMBER;
import static seedu.duke.common.MagicValues.INDEX_OF_MEDICINE_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_NOK_ADDRESS;
import static seedu.duke.common.MagicValues.INDEX_OF_NOK_EMAIL;
import static seedu.duke.common.MagicValues.INDEX_OF_NOK_PHONE_NUMBER;
import static seedu.duke.common.MagicValues.INDEX_OF_NOK_RELATIONSHIP;
import static seedu.duke.common.MagicValues.INDEX_OF_PURPOSE;
import static seedu.duke.common.MagicValues.INDEX_OF_TIME;
import static seedu.duke.common.MagicValues.LENGTH_IF_PURPOSE_EXISTS;
import static seedu.duke.common.MagicValues.INDEX_OF_NOK_NAME;
import static seedu.duke.common.MagicValues.INDEX_OF_BIRTHDAY;
import static seedu.duke.common.MagicValues.INDEX_OF_SYSTOLIC_PRESSURE;
import static seedu.duke.common.MagicValues.INDEX_OF_DIASTOLIC_PRESSURE;
import static seedu.duke.common.MagicValues.GENERAL_CHECKUP;
import static seedu.duke.common.MagicValues.INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY;
import static seedu.duke.common.MagicValues.INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY;
import static seedu.duke.common.MagicValues.parser;
import static seedu.duke.common.MagicValues.ui;
import static seedu.duke.common.MagicValues.re;

import static seedu.duke.common.Messages.NUMBER_OF_ELDERLY_STRING;


public class ElderlyList {


    protected static ArrayList<Elderly> elderlyArrayList = new ArrayList<Elderly>();
    protected static HashMap<String, HashSet<String>> medicineMapping = new HashMap<>();
    protected static HashMap<String, HashSet<String>> dietMapping = new HashMap<>();

    public ElderlyList() {
    }

    /**
     * Returns the elderly array list.
     *
     * @return elderlyArrayList is the elderly array list.
     */
    public ArrayList<Elderly> getElderlyArrayList() {
        return elderlyArrayList;
    }

    /**
     * Adds the elderly into the elderly array list.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addElderly(String userLine) {
        try {
            if (!re.isValidAddElderly(userLine)) {
                throw new ElderlyNotFoundException();
            }
            String[] paramList = userLine.split(NAME_SPLIT);
            String userName = paramList[INDEX_OF_ELDERLY_USERNAME];
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            elderlyArrayList.add(new Elderly(userName, elderlyName));
            ui.printAddElderlyMessage();
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Adds the medicine to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addMedicine(String userLine) {
        try {
            if (!re.isValidAddMedicine(userLine)) {
                throw new InvalidMedicineException();
            }
            String[] paramList = userLine.split(ADD_MEDICINE_SPLIT);
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            Elderly elderly = getElderly(elderlyName);
            String medicineName = paramList[INDEX_OF_MEDICINE_NAME];
            String frequency = paramList[INDEX_OF_FREQUENCY];
            assert paramList.length == 4 : "addmed input does not have all required values";
            elderly.addMedicine(new Medicine(medicineName, frequency));
            ui.printAddMedicineMessage();
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Views all medicine the elderly needs to take based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void viewMedicine(String userLine) {
        try {
            if (!re.isValidViewMedicine(userLine)) {
                throw new InvalidMedicineException();
            }
            String[] paramList = userLine.split(NAME_SPLIT);
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            assert paramList.length == 2 : "Username is empty";
            Elderly elderly = getElderly(elderlyName);
            printMedicines(elderly);
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Prints all the medicine, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    private void printMedicines(Elderly elderly) {
        int counter = 1;
        System.out.println("Medicine of " + elderly.getUsername() + " are shown below:");
        for (Medicine medicine : elderly.getMedicines()) {
            System.out.format("% 3d.", counter);
            System.out.println(medicine);
            counter++;
        }
    }

    /**
     * Adds the appointment to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addAppointment(String userLine) {
        try {
            if (!re.isValidAddAppointment(userLine)) {
                throw new InvalidAppointmentFormatException();
            }
            String[] paramList = userLine.split(ADD_APPOINTMENT_SPLIT);
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            Elderly elderly = getElderly(elderlyName);
            String location = paramList[INDEX_OF_LOCATION];
            String date = paramList[INDEX_OF_DATE];
            String time = paramList[INDEX_OF_TIME];
            String purpose;
            if (paramList.length == LENGTH_IF_PURPOSE_EXISTS) {
                purpose = paramList[INDEX_OF_PURPOSE];
            } else {
                purpose = GENERAL_CHECKUP;
            }
            assert paramList.length == 5 || paramList.length == 6 : "addappt input does not have all required values";
            elderly.addAppointment(new Appointment(location, date, time, purpose));
            ui.printAddAppointmentMessage();
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Views all appointments the elderly has based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void viewAppointment(String userLine) {
        try {
            if (!re.isValidViewAppointment(userLine)) {
                throw new InvalidAppointmentFormatException();
            }
            String[] paramList = userLine.split(NAME_SPLIT);
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            assert paramList.length == 2 : "Username is empty";
            Elderly elderly = getElderly(elderlyName);
            printAppointments(elderly);
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Prints all the appointments, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    private void printAppointments(Elderly elderly) {
        int counter = 1;
        System.out.println("Appointments of " + elderly.getUsername() + " are shown below:");
        for (Appointment appointment : elderly.getAppointments()) {
            System.out.format("% 3d.", counter);
            System.out.println(appointment);
            counter++;
        }
    }

    /**
     * Adds Next-Of-Kin information to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by user.
     */
    public void addNok(String userLine) {
        try {
            if (!re.isValidAddNok(userLine)) {
                throw new InvalidNokFormatException();
            }
            String[] paramList = userLine.split(ADD_NOK_SPLIT);
            assert paramList.length == 7 : "addnok input does not have all required values";
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            Elderly elderly = getElderly(elderlyName);
            String nokName = paramList[INDEX_OF_NOK_NAME];
            String nokPhoneNumber = paramList[INDEX_OF_NOK_PHONE_NUMBER];
            String nokEmail = paramList[INDEX_OF_NOK_EMAIL];
            String nokAddress = paramList[INDEX_OF_NOK_ADDRESS];
            String nokRelationship = paramList[INDEX_OF_NOK_RELATIONSHIP];
            elderly.addNok(new NextOfKin(nokName, nokPhoneNumber, nokEmail, nokAddress, nokRelationship));
            ui.printAddNokMessage();
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Views the Next-Of_kin information of the elderly based on input.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewNok(String userLine) {
        try {
            if (!re.isValidViewNok(userLine)) {
                throw new InvalidNokFormatException();
            }
            String[] paramList = userLine.split(NAME_SPLIT);
            assert paramList.length == 2 : "Username is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            Elderly elderly = getElderly(elderlyName);
            printNextOfKin(elderly);
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Prints the Next-Of-Kin information, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printNextOfKin(Elderly elderly) {
        System.out.println("Details of " + elderly.getUsername() + " Next-of-Kin are shown below:");
        System.out.println(elderly.getNextOfKin());
    }

    /**
     * Adds information to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by user.
     */
    public void addRecord(String userLine) {
        try {
            if (!re.isValidAddRecord(userLine)) {
                throw new InvalidElderlyRecordFormatException();
            }
            String[] paramList = userLine.split(ADD_RECORD_SPLIT);
            assert paramList.length == 4 : "addrec input does not have all required values";
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            Elderly elderly = getElderly(elderlyName);
            String elderlyPhoneNumber = paramList[INDEX_OF_ELDERLY_PHONE_NUMBER];
            String elderlyAddress = paramList[INDEX_OF_ELDERLY_ADDRESS];
            elderly.addRecord(new Record(elderlyPhoneNumber, elderlyAddress));
            ui.printAddRecordMessage();
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Views the information of the elderly based on input.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewRecord(String userLine) {
        try {
            if (!re.isValidViewRec(userLine)) {
                throw new InvalidElderlyRecordFormatException();
            }
            String[] paramList = userLine.split(NAME_SPLIT);
            assert paramList.length == 2 : "Username is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            Elderly elderly = getElderly(elderlyName);
            printRecord(elderly);
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Prints the information, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printRecord(Elderly elderly) {
        System.out.println("Record of " + elderly.getUsername() + " is shown below:");
        System.out.println(elderly.getRecord());
    }

    /**
     * Gets the Elderly object given the username.
     *
     * @param username String containing name of elderly.
     * @return Elderly object.
     */
    public Elderly getElderly(String username) throws ElderlyNotFoundException {
        int counter = 0;
        boolean elderlyExists = false;
        for (Elderly elderly : elderlyArrayList) {
            if (Objects.equals(elderly.getUsername(), username)) {
                elderlyExists = true;
                break;
            }
            counter++;
        }
        if (!elderlyExists) {
            throw new ElderlyNotFoundException();
        }
        //assert counter < getElderlyCount() : "Elderly is not found";
        return elderlyArrayList.get(counter);
    }

    /**
     * Views the blood pressure of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewBloodPressure(String userLine) {
        try {
            String[] paramList = userLine.split(" n/");
            assert paramList.length == 2 : "Username is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            Elderly elderly = getElderly(elderlyName);
            printBloodPressure(elderly);
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    private void printBloodPressure(Elderly elderly) {
        double[] bloodPuressure = elderly.getBloodPressure();
        System.out.printf("Blood pressure of %s is now (%.2f %.2f)%n", elderly.getUsername(),
                bloodPuressure[INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY],
                bloodPuressure[INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY]);
    }

    /**
     * Sets the blood pressure of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public Optional<Elderly> setBloodPressure(String userLine) {
        String[] paramList = userLine.split(" [nsd]/");
        assert paramList.length == 4 : "setbloodpressure input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
        double systolicPressure = Double.parseDouble(paramList[INDEX_OF_SYSTOLIC_PRESSURE]);
        double diastolicPressure = Double.parseDouble(paramList[INDEX_OF_DIASTOLIC_PRESSURE]);
        Elderly elderly;
        try {
            elderly = getElderly(elderlyName);
            elderly.setBloodPressure(systolicPressure, diastolicPressure);
            return Optional.of(elderly);
        } catch (ElderlyNotFoundException e) {
            return Optional.empty();
        }
    }

    /**
     * Views the birthday of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewBirthday(String userLine) {
        try {
            String[] paramList = userLine.split(" n/");
            assert paramList.length == 2 : "Name is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            Elderly elderly = getElderly(elderlyName);
            printBirthday(elderly);
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    private void printBirthday(Elderly elderly) {
        System.out.printf("Birthday of %s is %s%n", elderly.getUsername(), elderly.getBirthday());
    }

    /**
     * Sets the birthday of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public Optional<Elderly> setBirthday(String userLine) {
        String[] paramList = userLine.split(" [nb]/");
        assert paramList.length == 3 : "setbirthday input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
        String birthday = paramList[INDEX_OF_BIRTHDAY];
        Elderly elderly;
        try {
            elderly = getElderly(elderlyName);
            elderly.setElderlyBirthday(birthday);
            return Optional.of(elderly);
        } catch (ElderlyNotFoundException e) {
            return Optional.empty();
        }
    }

    /**
     * Sets the vaccination status of the elderly to be true.
     *
     * @param userLine Line that has been inputted by user.
     */
    public Optional<Elderly> setVaccinated(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "setvaccinated input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
        Elderly elderly;
        try {
            elderly = getElderly(elderlyName);
            elderly.setVaccinated();
            return Optional.of(elderly);
        } catch (ElderlyNotFoundException e) {
            return Optional.empty();
        }
    }

    /**
     * Gets the vaccination status of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void getVaccinationStatus(String userLine) {
        try {
            String[] paramList = userLine.split(" n/");
            assert paramList.length == 2 : "Username is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            Elderly elderly = getElderly(elderlyName);
            elderly.printVaccinationStatus();
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Sets the dietary preference of the elderly according to user's selection.
     *
     * @param userLine Line that has been inputted by user.
     */
    public Optional<Elderly> setDietaryPreference(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "setdiet input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
        Elderly elderly;
        try {
            elderly = getElderly(elderlyName);
            elderly.setDiet();
            return Optional.of(elderly);
        } catch (ElderlyNotFoundException e) {
            return Optional.empty();
        }
    }

    /**
     * Gets the dietary preference of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewDietaryPreference(String userLine) {
        try {
            String[] paramList = userLine.split(" n/");
            assert paramList.length == 2 : "Username is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_USERNAME];
            Elderly elderly = getElderly(elderlyName);
            elderly.printDietaryPreference();
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }


    /**
     * Get the number of elderly in the current list.
     */
    public int getElderlyCount() {
        return elderlyArrayList.size();
    }

    /**
     * Returns a consolidated String of all the elderly.
     *
     * @return String containing all the elderly information in the system.
     */
    public String getConsolidatedStringOfElderly() {
        return elderlyArrayList
                .stream()
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
    }

    /**
     * Prints current list of elderly along with number of elderly in system.
     */
    public void printElderly() {
        System.out.printf(NUMBER_OF_ELDERLY_STRING, getElderlyCount());
        ui.printElderlyList(getConsolidatedStringOfElderly());
    }

    /**
     * Builds the different mappings between medicine name, diet preference and names of elderly.
     */
    public void updateMappings() {
        // Creation of hashmap to do mapping between medicine and list of elderly that take given medicine
        for (Elderly elderlyObject : elderlyArrayList) {
            String elderlyName = elderlyObject.getUsername();
            // Update Medicine Mappings
            for (Medicine medicineObject : elderlyObject.getMedicines()) {
                String medicineName = medicineObject.getMedicineName();
                // Create new Medicine name to Elderly name HashSet Mapping if it doesn't exist
                if (!medicineMapping.containsKey(medicineName)) {
                    medicineMapping.put(medicineName, new HashSet<>());
                }
                // Append Elderly name to list of medicine mapping
                medicineMapping.get(medicineName).add(elderlyName);
            }
            // Update diet mappings
            String dietPreference = elderlyObject.getDiet();
            if (!dietMapping.containsKey(dietPreference)) {
                dietMapping.put(dietPreference, new HashSet<>());
            }
            dietMapping.get(dietPreference).add(elderlyName);
        }
    }

    /**
     * Returns a consolidated String of all elderly taking a given medicine.
     *
     * @param medicineQuery String containing medicine to be looked up.
     * @return String containing all the elderly names in the system that takes the medicine.
     */
    public String buildElderlyStringGivenMedicine(String medicineQuery) {
        String resultString = "";
        updateMappings();

        // Query HashSet for medicine name
        if (medicineMapping.containsKey(medicineQuery)) {
            // Gets all elderly names as a string
            resultString = String.join(System.lineSeparator(), medicineMapping.get(medicineQuery));
        }
        return resultString;
    }

    /**
     * Prints the list of elderly that is taking the searched medicine.
     *
     * @param userLine String containing medicine to be looked up.
     */
    public void getElderlyGivenMedicine(String userLine) {
        try {
            // Check if format is correct
            if (!re.isValidFindMed(userLine)) {
                throw new InvalidViewMedicineException();
            }

            String medicineQuery = parser.getMedicineFromSearchMed(userLine);
            ui.printQueryResultsIntroString(medicineQuery);
            String results = buildElderlyStringGivenMedicine(medicineQuery);
            if (results.isEmpty()) {
                checkSimilarities(medicineMapping.keySet(), medicineQuery);
            } else {
                System.out.println(results);
            }
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Returns a consolidated String of all elderly with a certain diet.
     *
     * @param dietQuery String containing diet preference to be looked up.
     * @return String containing all the elderly names in the system that has given diet preference.
     */
    public String buildElderlyStringGivenDiet(String dietQuery) {
        String resultString = "";
        updateMappings();

        // Query HashSet for diet name
        if (dietMapping.containsKey(dietQuery)) {
            // Gets all elderly names as a string
            resultString = String.join(System.lineSeparator(), dietMapping.get(dietQuery));
        }
        return resultString;
    }

    /**
     * Prints the list of elderly that is taking the searched diet preference.
     * TODO: Unable to test this function without fix to diet
     * @param userLine String containing diet to be looked up.
     */
    public void getElderlyGivenDiet(String userLine) {
        try {
            // Check if format is correct
            if (!re.isValidFindDiet(userLine)) {
                throw new InvalidViewDietException();
            }

            String dietQuery = parser.getDietFromSearchMed(userLine);
            ui.printQueryResultsIntroString(dietQuery);
            String results = buildElderlyStringGivenDiet(dietQuery);
            if (results.isEmpty()) {
                checkSimilarities(dietMapping.keySet(), dietQuery);
            } else {
                System.out.println(results);
            }
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Returns a consolidated String of all elderly information given real name.
     *
     * @param realName String containing real name to be looked out.
     * @return String containing all the elderly information in the system based on filter.
     */
    public String filterElderlyInformationGivenName(String realName) {
        return elderlyArrayList
                .stream()
                .filter((t) -> t.getName().contentEquals(realName))
                .map(Objects::toString)
                .reduce((t, u) -> t + '\n' + u)
                .orElse("");
    }

    /**
     * Get a list of all the real names in the system.
     * @return Array of all real names.
     */
    public Set<String> getAllRealNames() {
        return elderlyArrayList
                .stream()
                .map(Elderly::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Iterates through Strings and returns first result that has the highest similarities.
     * @param listOfStrings Set of Strings to search from.
     * @param searchTerm String with search term.
     */
    public void checkSimilarities(Set<String> listOfStrings, String searchTerm) {
        float highestResult = 0;
        HashMap<Float, String> resultToString = new HashMap<Float, String>();
        for (String stringInSet : listOfStrings) {
            float result = re.levenshteinDistance(searchTerm, stringInSet);
            if (highestResult < result) {
                highestResult = result;
            }
            resultToString.put(result, stringInSet);
        }

        // Print out closest match if similarity more than 0.80
        if (highestResult >= 0.80) {
            ui.printClosestMatch(resultToString.get(highestResult));
        } else {
            // Say that you don't understand what the user is looking for
            ui.printCannotFindQuery(searchTerm);
        }
    }

    /**
     * Prints a list of elderly and their details given real name.
     * @param userLine String containing real name to be looked out.
     */
    public void getAllElderlyDetailsByName(String userLine) {
        try {
            // Check if format is correct
            if (!re.isValidFindByName(userLine)) {
                throw new InvalidViewByNameException();
            }
            String realName = parser.getRealNameFromSearchName(userLine);
            ui.printQueryResultsIntroString(realName);
            String results = filterElderlyInformationGivenName(realName);
            if (results.isEmpty()) {
                Set<String> realNameArray = getAllRealNames();
                checkSimilarities(realNameArray, realName);
            } else {
                System.out.println(results);
            }
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    /**
     * Removes elderly from list given username.
     * @param userLine String containing username to be deleted from list.
     */
    public void deleteElderlyByUsername(String userLine) {
        int oldSize;
        int newSize;
        try {
            // Check if format is correct
            if (!re.isValidDeleteElderlyByUsername(userLine)) {
                throw new InvalidDeleteElderlyException();
            }
            String userName = parser.getUserNameFromDeleteElderly(userLine);
            oldSize = elderlyArrayList.size();
            elderlyArrayList
                    .removeIf((t) -> t.getUsername().contentEquals(userName));
            newSize = elderlyArrayList.size();
            if (oldSize > newSize) {
                ui.printDeleteByName(userName);
            } else {
                ui.printCannotFindQuery(userName);
            }
        } catch (DukeException e) {
            ui.printDukeException(e);
        }
    }
}
