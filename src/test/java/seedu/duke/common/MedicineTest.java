package seedu.duke.common;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MedicineTest {
    Medicine medicine;

    @BeforeEach
    public void setUp() {
        medicine = new Medicine("panadol", "once a day");
    }

    @Test
    void testMedicineDetails() {
        assertEquals(medicine.getMedicineName(), "panadol");
        assertEquals(medicine.getFrequency(), "once a day");
    }
}
