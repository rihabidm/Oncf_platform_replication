package codes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Todate {
    public static String convertTimestampToDate(String timestamp) {
        // Define a formatter for the input timestamp format
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            // Parse the timestamp string to LocalDateTime
            LocalDateTime dateTime = LocalDateTime.parse(timestamp, inputFormatter);

            // Format the LocalDateTime to a String with the desired date format 'yyyy-MM-dd'
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return dateTime.format(outputFormatter);
        } catch (Exception e) {
            // Handle parsing exceptions if needed
            e.printStackTrace();
            return null;
        }
    }

}
