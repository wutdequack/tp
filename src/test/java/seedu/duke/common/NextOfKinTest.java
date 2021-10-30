package seedu.duke.common;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class NextOfKinTest {
    static NextOfKin nextOfKin;

    @BeforeAll
    public static void setUp() {
        nextOfKin = new NextOfKin("tony lim", "92334500", "tonylim@yahoo.com",
                "23 yishun block 234", "son");
    }

    @Test
    void testNokDetails() {
        assertEquals(nextOfKin.getNokName(), "tony lim");
        assertEquals(nextOfKin.getNokPhoneNumber(), "92334500");
        assertEquals(nextOfKin.getNokEmail(), "tonylim@yahoo.com");
        assertEquals(nextOfKin.getNokAddress(), "23 yishun block 234");
        assertEquals(nextOfKin.getNokRelationship(), "son");
    }

}
