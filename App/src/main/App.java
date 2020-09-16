package main;

import system.CreateFile;
import system.Times;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {

        CreateFile cf = new CreateFile();
        cf.createFIle();

        LocalDate createDate = LocalDate.parse("2020-04-15");
        LocalDate createDate1 = LocalDate.parse("2019-04-14");
        LocalDate createDate2 = LocalDate.parse("2019-04-18");
        LocalDate createDate3 = LocalDate.parse("2019-04-19");
        LocalDate createDate4 = LocalDate.parse("2020-09-16");

        Times times = new Times(createDate, 1, 0);
        Times times1 = new Times(createDate1, 1, 0);
        Times times2 = new Times(createDate2, 1, 0);
        Times times3 = new Times(createDate3, 0, 30);
        Times times4 = new Times(createDate4, 0, 30);

        List<Times> list = new ArrayList<>();
        list.add(times);
        list.add(times1);
        list.add(times2);
        list.add(times3);
        list.add(times4);

        System.out.println("Dodano do listy czas nadliczbowy: ");
        for (Times l : list) {
            System.out.println(l);
        }

        System.out.println("Całkowity czas nadliczbowy w minutach:");
        List<Times> finalList = list;
        Function<Times, Integer> addAllTime = add -> {
            int sum = 0;
            for (Times x : finalList) {
                sum += x.minutes();
            }
            return sum;
        };

        int resum = addAllTime.apply(times);
        System.out.println(resum);

        Times timesout = new Times(createDate2, 0, 40);

        List<Times> list2 = new ArrayList<>();
        list2.add(timesout);

        System.out.println("Odebrany czas nadliczbowy w minutach:");
        for (Times l : list2) {
            System.out.println(l);
        }
        int receivingMinutes = 40;
        int subtractionMinutes = (resum - receivingMinutes);
        System.out.println("Odebrano: " + receivingMinutes + ", pozostało: " + subtractionMinutes + " minut.");


        //zapis danych do pliku
        String nameFile = "fileDateAndHours.txt";
        try (
                var fs = new FileOutputStream(nameFile);
                var os = new ObjectOutputStream(fs);
        ) {
            os.writeObject(list);
            System.out.println("Zapisano dane do pliku");

        } catch (IOException e) {
            System.err.println("Bład zapisu pliku " + nameFile);
            e.printStackTrace();
        }

        //odczyt danych z pliku
        try (
                var fis = new FileInputStream(nameFile);
                var ois = new ObjectInputStream(fis);
        ) {
            list = (List<Times>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Nie udało się odczytać pliku");
            e.printStackTrace();
        }

        if (list != null) {
            System.out.println("Wczytano dane z pliku: " + "\n" + "Dane dotyczące czasu nadliczbowego:");
            for (Times t: list){
                System.out.println(t);
            }
        }

    }
}
