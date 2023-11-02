package HexletExcersises.Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class App1 {

    static Date birthDate = new Date(91, 0, 26);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        Locale loc = new Locale("ru");
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE", loc);
        return formatter.format(date);
    }
}
