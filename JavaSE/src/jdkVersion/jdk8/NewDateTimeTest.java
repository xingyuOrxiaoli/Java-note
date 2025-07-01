package jdkVersion.jdk8;

import java.time.*;

public class NewDateTimeTest {
    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println(instant);

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalTime todayTime = LocalTime.now();
        System.out.println(todayTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        Period period = Period.ofDays(1);
        System.out.println(period);

        ZoneOffset zoneOffset = ZoneOffset.ofHours(8);
        System.out.println(zoneOffset);

        Clock clock = Clock.systemUTC();
        System.out.println(clock);


    }
}
