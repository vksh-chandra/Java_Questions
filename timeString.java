import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class timeString {
    public static void main(String[] args) {
        String string = "August 25, 2021";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(string, formatter);
        System.out.println(date);
    }
}
