package de.ur.mi.android.demos.spielplan.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataFormatter {

    public static String createDateStringForUI(LocalDateTime date) {
        return createDateStringForUI(date.toLocalDate());
    }

    public static String createDateStringForUI(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd. MMMM YYYY");
        return date.format(formatter);
    }
}
