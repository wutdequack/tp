package seedu.duke.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AppointmentTest {
    Appointment generalAppointment;

    @BeforeEach
    public void setUp() {
        generalAppointment = new Appointment("khoo teck puat hospital", "01012021",
                "0900", "general checkup");
    }

    @Test
    void testAppointmentDetails() {
        assertEquals(generalAppointment.getLocation(), "khoo teck puat hospital");
        assertEquals(generalAppointment.getDate(), "01012021");
        assertEquals(generalAppointment.getTime(), "0900");
        assertEquals(generalAppointment.getPurpose(), "general checkup");
    }
}
