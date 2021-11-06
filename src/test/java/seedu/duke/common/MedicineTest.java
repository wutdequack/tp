package seedu.duke.common;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MedicineTest {
    static Medicine medicine;

    @BeforeAll
    public static void setUp() {
        medicine = new Medicine("panadol", "once a day");
    }

    @Test
    void testMedicineDetails() {
        assertEquals(medicine.getMedicineName(), "panadol");
        assertEquals(medicine.getFrequency(), "once a day");
    }

    @Test
    void testMedicineToString() {
        String expectedOutput = "Medicine Name: panadol, Frequency: once a day";
        assertEquals(expectedOutput, medicine.toString());
    }
}
