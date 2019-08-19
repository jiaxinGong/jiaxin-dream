package newDate;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
//import java.time.temporal.ChronoUnit;
import java.time.temporal.ChronoUnit;
import org.junit.Test;
//import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/10 13:37
 */
public class Demo {

    @Test
    public void testLocalDate() {
//        LocalDate date = LocalDate.of(2018,8,9);
        LocalDate date = LocalDate.parse("2018-08-10");
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        System.out.println("year:" + year);
        System.out.println("month:" + month);
        System.out.println("day:" + day);
        System.out.println("dayOfWeek:" + dayOfWeek);
        System.out.println("len:" + len);
        System.out.println("leap:" + leap);
        System.out.println("now:" + date.now());
        System.out.println("=======================");
        year = date.get(ChronoField.YEAR);
        System.out.println("year:" + year);
    }

    @Test
    public void testLocalTime() {
//        LocalTime time = LocalTime.of(13,49,30);
        LocalTime time = LocalTime.parse("13:09:10");
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println("hour:" + hour);
        System.out.println("minute:" + minute);
        System.out.println("second:" + second);
        System.out.println("now:" + time.now());

    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 8, 10, 15, 16, 39);
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());
    }

    @Test
    public void testDuration() {
        Period period = Period.between(LocalDate.of(2018, 8, 1), LocalDate.of(2018, 8, 10));
//        period.getDays()
        System.out.println("period:" + period.getDays());
        System.out.println("period:" + period.getDays());

        Duration duration = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println("duration.getSeconds():" + duration.getSeconds());
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2019,8,5,17,55,01);
        LocalDateTime localDateTime2 = LocalDateTime.of(2019,8,5,17,57,58);
        Duration duration = Duration.between(localDateTime,localDateTime2);
        System.out.println(duration.getSeconds());
        System.out.println(duration.getSeconds());
        System.out.println(duration.getSeconds());
        System.out.println(System.currentTimeMillis());
    }
}
