package seedu.duke.list;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.common.Elderly;
import seedu.duke.common.Medicine;
import seedu.duke.common.Appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class ElderlyListTest {
    ElderlyList elderlyList = new ElderlyList();

    @BeforeEach
    public void setUp() throws Exception {
        elderlyList.addElderly("addelderly n/johntan123");
    }

    @Test
    public void checkName() {
        String expectedOutput = "johntan123";
        //System.out.println(elderlyList.getElderly("johntan123").getName());
        //assertTrue(elderlyArrayList.size() == 1);
        assertEquals(expectedOutput, elderlyList.getElderly("johntan123").getName());
    }


}
