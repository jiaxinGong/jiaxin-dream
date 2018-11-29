package thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataFormat {

    public static void main(String[] args) {
        System.out.println(df.get().format(new Date()));

        System.out.println("=================");

        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime));

        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime));
    }

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };


}
