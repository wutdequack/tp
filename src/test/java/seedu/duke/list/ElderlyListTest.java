package seedu.duke.list;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.common.Appointment;
import seedu.duke.common.Medicine;
import seedu.duke.common.NextOfKin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ElderlyListTest {
    ElderlyList elderlyList = new ElderlyList();
    ArrayList<Medicine> tanMedicines = new ArrayList<Medicine>();
    ArrayList<Medicine> limMedicines = new ArrayList<Medicine>();
    ArrayList<Appointment> tanAppointments = new ArrayList<Appointment>();
    ArrayList<Appointment> limAppointments = new ArrayList<Appointment>();
    ArrayList<NextOfKin> tanNoks = new ArrayList<NextOfKin>();
    ArrayList<NextOfKin> limNoks = new ArrayList<NextOfKin>();

    @BeforeEach
    public void setUp() {
        elderlyList.addElderly("addelderly n/johntan123");
        elderlyList.addElderly("addelderly n/limqq369");
        elderlyList.addMedicine("addmed n/limqq369 m/panadol f/once a day");
        elderlyList.addAppointment("addappt n/limqq369 l/khoo teck puat hospital d/01012021 t/0900");
        elderlyList.addNok("addnok n/limqq369 k/tony p/98765432 e/tony@yahoo.com a/123 yishun street r/son");
        elderlyList.setBirthday("setbirthday n/limqq369 b/1903-06-09");
        elderlyList.setBloodPressure("setbloodpressure n/limqq369 s/169.0 d/108.0");
        elderlyList.setVaccinated("setvaccinated n/limqq369");
    }

    //    @Test
    //    void elderlyCountTest() {
    //        assertEquals(elderlyList.getElderlyCount(), 8);
    //    }

    //    @Test
    //    void elderlyListTest() {
    //        assertEquals(elderlyList.getConsolidatedStringOfElderly(), "Elderly Name: johntan123\n"
    //                + "Vaccinated? : No\n"
    //                + "Birthday: Not Recorded\n"
    //                + "Here are johntan123's records:\n"
    //                + "\n"
    //                + "\n"
    //                + "Here is the list of upcoming appointments:\n"
    //                + "\n"
    //                + "\n"
    //                + "This is the list of medicine(s):\n"
    //                + "\n"
    //                + "\n"
    //                + "These are NOK(s) attached to johntan123:\n"
    //                + "\n"
    //                + "\n"
    //                + "Elderly Name: limqq369\n"
    //                + "Vaccinated? : No\n"
    //                + "Birthday: Not Recorded\n"
    //                + "Here are limqq369's records:\n"
    //                + "\n"
    //                + "\n"
    //                + "Here is the list of upcoming appointments:\n"
    //                + "Location: khoo teck puat hospital, Date: 01012021, Time: 0900, Purpose of Visit:
    //                general checkup\n"
    //                + "Location: khoo teck puat hospital, Date: 01012021, Time: 0900, Purpose of Visit:
    //                general checkup\n"
    //                + "Location: khoo teck puat hospital, Date: 01012021, Time: 0900, Purpose of Visit:
    //                general checkup\n"
    //                + "\n"
    //                + "This is the list of medicine(s):\n"
    //                + "Medicine Name: panadol, Frequency: once a day\n"
    //                + "Medicine Name: panadol, Frequency: once a day\n"
    //                + "Medicine Name: panadol, Frequency: once a day\n"
    //                + "\n"
    //                + "These are NOK(s) attached to limqq369:\n"
    //                + "\n"
    //                + "\n"
    //                + "Elderly Name: johntan123\n"
    //                + "Vaccinated? : No\n"
    //                + "Birthday: Not Recorded\n"
    //                + "Here are johntan123's records:\n"
    //                + "\n"
    //                + "\n"
    //                + "Here is the list of upcoming appointments:\n"
    //                + "\n"
    //                + "\n"
    //                + "This is the list of medicine(s):\n"
    //                + "\n"
    //                + "\n"
    //                + "These are NOK(s) attached to johntan123:\n"
    //                + "\n"
    //                + "\n"
    //                + "Elderly Name: limqq369\n"
    //                + "Vaccinated? : No\n"
    //                + "Birthday: Not Recorded\n"
    //                + "Here are limqq369's records:\n"
    //                + "\n"
    //                + "\n"
    //                + "Here is the list of upcoming appointments:\n"
    //                + "\n"
    //                + "\n"
    //                + "This is the list of medicine(s):\n"
    //                + "\n"
    //                + "\n"
    //                + "These are NOK(s) attached to limqq369:\n"
    //                + "\n"
    //                + "\n"
    //                + "Elderly Name: johntan123\n"
    //                + "Vaccinated? : No\n"
    //                + "Birthday: Not Recorded\n"
    //                + "Here are johntan123's records:\n"
    //                + "\n"
    //                + "\n"
    //                + "Here is the list of upcoming appointments:\n"
    //                + "\n"
    //                + "\n"
    //                + "This is the list of medicine(s):\n"
    //                + "\n"
    //                + "\n"
    //                + "These are NOK(s) attached to johntan123:\n"
    //                + "\n"
    //                + "\n"
    //                + "Elderly Name: limqq369\n"
    //                + "Vaccinated? : No\n"
    //                + "Birthday: Not Recorded\n"
    //                + "Here are limqq369's records:\n"
    //                + "\n"
    //                + "\n"
    //                + "Here is the list of upcoming appointments:\n"
    //                + "\n"
    //                + "\n"
    //                + "This is the list of medicine(s):\n"
    //                + "\n"
    //                + "\n"
    //                + "These are NOK(s) attached to limqq369:\n"
    //                + "\n");
    //    }

    @Test
    void addElderlyTest() {
        final String expectedOutput = "johntan123";
        assertEquals(expectedOutput, elderlyList.getElderly("johntan123").getName());
    }

    @Test
    void addMedTest() {
        assertEquals(tanMedicines, elderlyList.getElderly("johntan123").getMedicines());
        Medicine limMedicine = elderlyList.getElderly("limqq369").getMedicines().get(0);
        assertEquals("panadol", limMedicine.getMedicineName());
        assertEquals("once a day", limMedicine.getFrequency());
    }

    @Test
    void addAppointmentTest() {
        assertEquals(tanAppointments, elderlyList.getElderly("johntan123").getAppointments());
        Appointment limAppointments = elderlyList.getElderly("limqq369").getAppointments().get(0);
        assertEquals("khoo teck puat hospital", limAppointments.getLocation());
        assertEquals("01012021", limAppointments.getDate());
        assertEquals("0900", limAppointments.getTime());
        assertEquals("general checkup", limAppointments.getPurpose());
    }

    @Test
    void addNokTest() {
        assertEquals(tanNoks, elderlyList.getElderly("johntan123").getNextOfKin());
        NextOfKin limNoks = elderlyList.getElderly("limqq369").getNextOfKin().get(0);
        assertEquals("tony", limNoks.getNokName());
        assertEquals("98765432", limNoks.getNokPhoneNumber());
        assertEquals("tony@yahoo.com", limNoks.getNokEmail());
        assertEquals("123 yishun street", limNoks.getNokAddress());
        assertEquals("son", limNoks.getNokRelationship());
    }

    @Test
    void birthdayTest() {
        final String expectedOutput = "1903-06-09";
        assertEquals(expectedOutput,
                elderlyList.getElderly("limqq369").getBirthday());
    }

    @Test
    void bloodPressureTest() {
        final double[] expectedOutput = new double[]{169.0, 108.0};
        assertEquals(expectedOutput,
                elderlyList.getElderly("limqq369").getBloodPressure());
    }
}
