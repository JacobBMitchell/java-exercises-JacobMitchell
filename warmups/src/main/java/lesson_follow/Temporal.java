package lesson_follow;

import java.time.*;
import java.util.Random;

public class Temporal {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.getDayOfWeek());
        System.out.println(LocalTime.now());
        System.out.println(today.plusWeeks(1));

        LocalDate beginning = LocalDate.of(2003,2,13);
        Period difference =  beginning.until(today);

        difference = Period.between(beginning,today);
        System.out.println(difference.getDays());
        System.out.println(today.plus(difference));

        Random rand = new Random();
        int year = LocalDate.now().getYear();
        int dayOfMonth = rand.nextInt(Month.AUGUST.maxLength()) + 1;

        LocalDate day = LocalDate.of(year, Month.AUGUST, dayOfMonth);
        LocalDate stop = day.plusWeeks(2);

        for (; day.compareTo(stop) < 0; day = day.plusDays(1)) {
            if (day.getDayOfWeek() != DayOfWeek.SATURDAY && day.getDayOfWeek() != DayOfWeek.SUNDAY) {
                System.out.printf("%s: %s%n", day.getDayOfWeek(), day);
            }
        }
    }
}
