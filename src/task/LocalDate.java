package task;

import java.time.DateTimeException;

public class LocalDate extends DateTimeException {
    public LocalDate(String message) {
        super(message);
    }
}
