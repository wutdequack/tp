package seedu.duke.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ElderlyTest {
    Elderly johnTan;

    @BeforeEach
    public void setUp() {
        johnTan = new Elderly("johntan123");
    }

    @Test
    void testElderlyDetails() {
        assertEquals(johnTan.getName(), "johntan123");
    }

    @Test
    void testElderlyToString() {
        assertEquals(johnTan.toString(), "Elderly Name: johntan123\n"
                + "Vaccination status of johntan123: Not vaccinated\n"
                + "Birthday of johntan123: Not Recorded\n"
                + "Here are johntan123's records:\n"
                + "\n"
                + "\n"
                + "Here is the list of upcoming appointments:\n"
                + "\n"
                + "\n"
                + "This is the list of medicine(s):\n"
                + "\n"
                + "\n"
                + "These are NOK(s) attached to johntan123:\n"
                + "\n");
        johnTan.setVaccinated();
        assertEquals(johnTan.toString(), "Elderly Name: johntan123\n"
                + "Vaccination status of johntan123: Vaccinated\n"
                + "Birthday of johntan123: Not Recorded\n"
                + "Here are johntan123's records:\n"
                + "\n"
                + "\n"
                + "Here is the list of upcoming appointments:\n"
                + "\n"
                + "\n"
                + "This is the list of medicine(s):\n"
                + "\n"
                + "\n"
                + "These are NOK(s) attached to johntan123:\n"
                + "\n");
    }

}
