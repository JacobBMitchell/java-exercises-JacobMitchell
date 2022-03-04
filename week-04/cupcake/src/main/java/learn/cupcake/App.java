package learn.cupcake;

import learn.cupcake.data.Repository;
import learn.cupcake.models.Entry;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        /*

        Cupcake

        https://trends.google.com/trends/explore?date=all&q=%2Fm%2F03p1r4

        Numbers represent search interest relative to the highest point on the chart for the given region and time.
        A value of 100 is the peak popularity for the term. A value of 50 means that the term is half as popular.
        A score of 0 means there was not enough data for this term.

        1) Use manual looping to answer the following questions:

        a) Display the rankings for 2010
        b) Which month/years has the highest ranking?
        c) Which month was the first month to have a ranking of 50 or greater?
        d) Which year has the highest average ranking?

        2) Use the Streams API to answer the same questions.

         */

        Repository repository = new Repository("./data/google-trends-data.csv");

        List<Entry> entries = repository.getEntries();
        System.out.println(entries.size());

//a
        entries.stream().filter(a -> a.getYearMonth().getYear() == 2010)
                .forEach(System.out::println);
//b
        YearMonth highest = entries.stream().min((a, b)->b.getScore()-a.getScore())
                .get().getYearMonth();
        System.out.println(highest);
//c
        YearMonth popular = entries.stream().filter(a -> a.getScore() >= 50)
                .sorted(Comparator.comparing(Entry::getYearMonth))
                .collect(Collectors.toList())
                .get(0).getYearMonth();
        System.out.println(popular);

        //look for things and define the key
        Map<Integer, Double> averageByYear = entries.stream()
                .collect(
                        Collectors.groupingBy(a -> a.getYearMonth().getYear(),
                        Collectors.averagingDouble(Entry::getScore)));

        for (Integer year: averageByYear.keySet().stream().sorted().collect(Collectors.toList())){
            System.out.println(year + ": "+ averageByYear.get(year));
        }

        //Map<Integer, Double> averageByYear = chronoOrder.

        //start of new year, we want to add a entry to the list that is the average over the month
        //each month we want to add to the sum
        //divide sum by 12

//
//        Optional<Entry> Max = entries.stream().min((a, b)-> b.getScore() - a.getScore());
//        //Max.
//        System.out.println(Max);


        //Max.forEach(System.out::println);
    }
}
