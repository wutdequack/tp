package seedu.duke.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.hospital.Hospital;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MediumRiskElderlyTest {
    MediumRiskElderly hotchic31;
    Hospital hospital;

    @BeforeEach
    public void setUp() {
        hospital = new Hospital("changi general hospital", 67888833);
        hotchic31 = new MediumRiskElderly("hotchic31", "Owin Soh", hospital,
                "cataract removed, history of stroke, obesity",
                "requires putting of eyedrops every 5 hours. blood pressure and heart rate to be measured "
                        + "daily to ensure lower possibility of reoccurrence of stroke. watch diet intake.");
    }

    @Test
    void testElderlyDetails() {
        assertEquals(hotchic31.getUsername(), "hotchic31");
    }

    @Test
    void testElderlyToString() {
        assertEquals(hotchic31.toString(), "Elderly Username: hotchic31\n"
                + "Elderly Name: Owin Soh\n"
                + "Risk Level : MEDIUM\n"
                + "Vaccination status of hotchic31: Not vaccinated\n"
                + "Birthday of hotchic31: Not Recorded\n"
                + "Here are hotchic31's records:\n"
                + "\n"
                + "\n"
                + "Here is the list of upcoming appointments:\n"
                + "\n"
                + "\n"
                + "This is the list of medicine(s):\n"
                + "\n"
                + "\n"
                + "These are NOK(s) attached to hotchic31:\n"
                + "\n"
                + "\n"
                + "Hospital Details :\n"
                + "changi general hospital (Hospital Name)\n"
                + "67888833 (Hospital Number)\n"
                + "\n"
                + "Conditions of elderly hotchic31 : cataract removed, history of stroke, obesity\n"
                + "\n"
                + "Notes on care for hotchic31 : requires putting of eyedrops every 5 hours. blood pressure and heart"
                + " rate to be measured daily to ensure lower possibility of reoccurrence of stroke. "
                + "watch diet intake.\n");
    }
}
