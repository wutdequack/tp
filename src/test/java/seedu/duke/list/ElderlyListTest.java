package seedu.duke.list;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.common.Appointment;
import seedu.duke.common.Medicine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ElderlyListTest {
    ElderlyList elderlyList = new ElderlyList();
    ArrayList<Medicine> tanMedicines = new ArrayList<Medicine>();
    ArrayList<Medicine> limMedicines = new ArrayList<Medicine>();
    ArrayList<Appointment> tanAppointments = new ArrayList<Appointment>();
    ArrayList<Appointment> limAppointments = new ArrayList<Appointment>();

    @BeforeEach
    public void setUp() {
        elderlyList.addElderly("addelderly n/johntan123");
        elderlyList.addElderly("addelderly n/limqq369");
        elderlyList.addMedicine("addmed n/limqq369 m/panadol f/once a day");
        elderlyList.addAppointment("addappt n/limqq369 l/khoo teck puat hospital d/01012021 t/0900");
    }

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
        assertEquals("once a day",limMedicine.getFrequency());
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
}
