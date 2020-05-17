package main;

import system.Times;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {

        LocalDate createDate = LocalDate.parse("2020-04-15");
        LocalDate createDate1 = LocalDate.parse("2019-04-14");
        LocalDate createDate2 = LocalDate.parse("2019-04-18");


        Times times = new Times(createDate, 1, 20);
        Times times1 = new Times(createDate1, 1, 30);
        Times times2 = new Times(createDate1, 1, 0);
        Times times3 = new Times(createDate1, 0, 30);

        List<Times> list = new ArrayList<>();
        list.add(times);
        list.add(times1);
        list.add(times2);
        list.add(times3);


        System.out.println("Dodano do listy czas nadliczbowy: ");
        for (Times l : list) {
            System.out.println(l);
        }


        System.out.println("Całkowity czas nadliczbowy w minutach:");
        Function<Times, Integer> addAllTime = add -> {
            int sum = 0;
            for (Times x : list) {
                sum += x.minutes();
            }
            return sum;
        };
        int resum = addAllTime.apply(times);
        System.out.println(resum);

        Times times4 = new Times(createDate2, 0, 40);

        List<Times> list2 = new ArrayList<>();
        list2.add(times4);

        System.out.println("Odebrany czas nadliczbowy w minutach:");
        for (Times l : list2) {
            System.out.println(l);
        }
        int receivingMinutes = 40;
        int subtractionMinutes = (resum - receivingMinutes);
        System.out.println("Odebrano: " + receivingMinutes + ", pozostało: " + subtractionMinutes + " minut.");

    }
}
