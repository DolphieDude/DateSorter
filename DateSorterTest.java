import java.time.LocalDate;
import java.util.*;

public class DateSorterTest {

    public static void main(String[] args) {
        List<LocalDate> unsortedDates;
        DateSorter dataSorter = new DateSorter();
        unsortedDates = Arrays.asList(
                LocalDate.parse("2005-07-01"),
                LocalDate.parse("2005-01-02"),
                LocalDate.parse("2005-01-01"),
                LocalDate.parse("2005-05-03")
        );
        Collection<LocalDate> list = dataSorter.sortDates(unsortedDates);
        System.out.println(list);
    }
}
