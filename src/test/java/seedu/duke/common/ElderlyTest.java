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

}
