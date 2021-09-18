package codecheck;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static void main(String[] args) {
       String fileDate =  LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

        String startDate = OffsetDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

        System.out.println(startDate);

        String endDate = OffsetDateTime.now(ZoneOffset.UTC).minusDays(1).
                format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

        System.out.println(endDate);
    }
}
