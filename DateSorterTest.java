import java.time.LocalDate;
import java.util.*;

public class DateSorterTest {

    public static void main(String[] args) {
        List<LocalDate> unsortedDates, expected;
        DateSorter dateSorter1 = new DateSorter();
        DateSorterSecond dateSorter2 = new DateSorterSecond();

        unsortedDates = Arrays.asList(
                LocalDate.parse("2005-07-01"),
                LocalDate.parse("2005-01-02"),
                LocalDate.parse("2005-01-01"),
                LocalDate.parse("2005-05-03")
        );
        expected = Arrays.asList(
                LocalDate.parse("2005-01-01"),
                LocalDate.parse("2005-01-02"),
                LocalDate.parse("2005-07-01"),
                LocalDate.parse("2005-05-03")
        );

        Collection<LocalDate> actual = dateSorter1.sortDates(unsortedDates);
        System.out.println(actual);
        if (actual.equals(expected)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        actual = dateSorter2.sortDates(unsortedDates);
        System.out.println(actual);
        if (actual.equals(expected)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");

        }
    }
}
