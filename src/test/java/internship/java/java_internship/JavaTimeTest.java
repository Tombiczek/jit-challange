package internship.java.java_internship;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaTimeTest {


    LocalTime startTime = LocalTime.parse("08:00:00");
    LocalTime endTime = LocalTime.parse("16:00:00");
    LocalDateTime targetTime = LocalDateTime.parse("2025-05-05T11:00:00");


    @Test
    void checkIfTimeIsWithinRange() {
        assertTrue(!targetTime.toLocalTime().isBefore(startTime) &&
                !targetTime.toLocalTime().isAfter(endTime));
    }
}
