package seedu.duke.list;

import java.util.ArrayList;

import seedu.duke.common.Elderly;
import seedu.duke.common.Medicine;
import seedu.duke.common.Appointment;
import seedu.duke.common.NextOfKin;
import seedu.duke.common.Record;

import seedu.duke.exceptions.ElderlyNotFoundException;
import seedu.duke.exceptions.InvalidElderlyRecordFormatException;
import seedu.duke.exceptions.InvalidNokFormatException;
import seedu.duke.exceptions.InvalidMedicineException;
import seedu.duke.exceptions.InvalidAppointmentFormatException;

import java.util.Objects;
import java.util.Optional;

import static seedu.duke.common.MagicValues.ADD_NOK_SPLIT;
import static seedu.duke.common.MagicValues.ADD_RECORD_SPLIT;
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
import static seedu.duke.common.MagicValues.ui;
import static seedu.duke.common.MagicValues.re;

import static seedu.duke.common.Messages.NUMBER_OF_ELDERLY_STRING;


public class ElderlyList {


    protected static ArrayList<Elderly> elderlyArrayList = new ArrayList<Elderly>();

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
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            elderlyArrayList.add(new Elderly(elderlyName));
            ui.printAddElderlyMessage();
        } catch (ElderlyNotFoundException e) {
            ui.printInvalidAddElderlyMessage();
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
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            Elderly elderly = getElderly(elderlyName);
            String medicineName = paramList[INDEX_OF_MEDICINE_NAME];
            String frequency = paramList[INDEX_OF_FREQUENCY];
            assert paramList.length == 4 : "addmed input does not have all required values";
            elderly.addMedicine(new Medicine(medicineName, frequency));
            ui.printAddMedicineMessage();
        } catch (InvalidMedicineException e) {
            ui.printInvalidAddMedicineMessage();
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
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
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            assert paramList.length == 2 : "Name is empty";
            Elderly elderly = getElderly(elderlyName);
            printMedicines(elderly);
        } catch (InvalidMedicineException e) {
            ui.printInvalidViewMedicineMessage();
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
        }
    }

    /**
     * Prints all the medicine, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    private void printMedicines(Elderly elderly) {
        int counter = 1;
        System.out.println("Medicine of " + elderly.getName() + " are shown below:");
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
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
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
        } catch (InvalidAppointmentFormatException e) {
            ui.printInvalidAddAppointmentMessage();
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
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
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            assert paramList.length == 2 : "Name is empty";
            Elderly elderly = getElderly(elderlyName);
            printAppointments(elderly);
        } catch (InvalidAppointmentFormatException e) {
            ui.printInvalidViewAppointmentMessage();
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
        }
    }

    /**
     * Prints all the appointments, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    private void printAppointments(Elderly elderly) {
        int counter = 1;
        System.out.println("Appointments of " + elderly.getName() + " are shown below:");
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
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            Elderly elderly = getElderly(elderlyName);
            String nokName = paramList[INDEX_OF_NOK_NAME];
            String nokPhoneNumber = paramList[INDEX_OF_NOK_PHONE_NUMBER];
            String nokEmail = paramList[INDEX_OF_NOK_EMAIL];
            String nokAddress = paramList[INDEX_OF_NOK_ADDRESS];
            String nokRelationship = paramList[INDEX_OF_NOK_RELATIONSHIP];
            elderly.addNok(new NextOfKin(nokName, nokPhoneNumber, nokEmail, nokAddress, nokRelationship));
            ui.printAddNokMessage();
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
        } catch (InvalidNokFormatException e) {
            ui.printInvalidAddNokMessage();
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
            assert paramList.length == 2 : "Name is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            Elderly elderly = getElderly(elderlyName);
            printNextOfKin(elderly);
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
        } catch (InvalidNokFormatException e) {
            ui.printInvalidViewNokMessage();
        }
    }

    /**
     * Prints the Next-Of-Kin information, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printNextOfKin(Elderly elderly) {
        System.out.println("Details of " + elderly.getName() + " Next-of-Kin are shown below:");
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
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            Elderly elderly = getElderly(elderlyName);
            String elderlyPhoneNumber = paramList[INDEX_OF_ELDERLY_PHONE_NUMBER];
            String elderlyAddress = paramList[INDEX_OF_ELDERLY_ADDRESS];
            elderly.addRecord(new Record(elderlyPhoneNumber, elderlyAddress));
            ui.printAddRecordMessage();
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
        } catch (InvalidElderlyRecordFormatException e) {
            ui.printInvalidAddRecordMessage();
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
            assert paramList.length == 2 : "Name is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            Elderly elderly = getElderly(elderlyName);
            printRecord(elderly);
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
        } catch (InvalidElderlyRecordFormatException e) {
            ui.printInvalidViewRecordMessage();
        }
    }

    /**
     * Prints the information, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printRecord(Elderly elderly) {
        System.out.println("Record of " + elderly.getName() + " is shown below:");
        System.out.println(elderly.getRecord());
    }

    /**
     * Gets the Elderly object given the name.
     *
     * @param name String containing name of elderly.
     * @return Elderly object.
     */
    public Elderly getElderly(String name) throws ElderlyNotFoundException {
        int counter = 0;
        boolean elderlyExists = false;
        for (Elderly elderly : elderlyArrayList) {
            if (Objects.equals(elderly.getName(), name)) {
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
            assert paramList.length == 2 : "Name is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            Elderly elderly = getElderly(elderlyName);
            printBloodPressure(elderly);
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
        }
    }

    private void printBloodPressure(Elderly elderly) {
        double[] bloodPuressure = elderly.getBloodPressure();
        System.out.printf("Blood pressure of %s is now (%.2f %.2f)%n", elderly.getName(),
                bloodPuressure[0], bloodPuressure[1]);
    }

    /**
     * Sets the blood pressure of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public Optional<Elderly> setBloodPressure(String userLine) {
        String[] paramList = userLine.split(" [nsd]/");
        assert paramList.length == 4 : "setbloodpressure input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
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
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            Elderly elderly = getElderly(elderlyName);
            printBirthday(elderly);
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
        }
    }

    private void printBirthday(Elderly elderly) {
        System.out.printf("Birthday of %s is %s%n", elderly.getName(), elderly.getBirthday());
    }

        /**
         * Sets the birthday of the elderly.
         *
         * @param userLine Line that has been inputted by user.
         */
        public Optional<Elderly> setBirthday(String userLine) {
            String[] paramList = userLine.split(" [nb]/");
            assert paramList.length == 3 : "setbirthday input does not have all required values";
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            String birthday = paramList[INDEX_OF_BIRTHDAY];
            Elderly elderly;
            try {
                elderly = getElderly(elderlyName);
                elderly.setElderlyBirthday(birthday);
                return Optional.of(elderly);
            } catch(ElderlyNotFoundException e) {
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
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
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
            assert paramList.length == 2 : "Name is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            Elderly elderly = getElderly(elderlyName);
            elderly.printVaccinationStatus();
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
        }
    }

    /**
     * Sets the dietary preference of the elderly to be true.
     *
     * @param userLine Line that has been inputted by user.
     */
    public Optional<Elderly> setDietaryPreference(String userLine) {
        String[] paramList = userLine.split(" n/");
        assert paramList.length == 2 : "setdiet input does not have all required values";
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
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
            assert paramList.length == 2 : "Name is empty";
            String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
            Elderly elderly = getElderly(elderlyName);
            elderly.printVaccinationStatus();
        } catch (ElderlyNotFoundException e) {
            ui.printNoSuchElderly();
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
     * Print current list of elderly along with number of elderly in system.
     */
    public void printElderly() {
        System.out.printf(NUMBER_OF_ELDERLY_STRING, getElderlyCount());
        ui.printElderlyList(getConsolidatedStringOfElderly());
    }

}
