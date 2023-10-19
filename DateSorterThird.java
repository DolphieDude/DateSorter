import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 * Implement in single class.
 */
public class DateSorterThird {
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
     * would sort to
     * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        Stream<LocalDate> sortedDatesStream = unsortedDates.stream()
                .sorted((thisDate, nextDate) -> {
                    int comparisonResult;
                    boolean doesThisContainR = thisDate.getMonth().toString().contains("R");
                    boolean doesNextContainR = nextDate.getMonth().toString().contains("R");

                    if (doesThisContainR && doesNextContainR) {
                        comparisonResult = thisDate.compareTo(nextDate);
                    }
                    else if (!doesThisContainR && !doesNextContainR) {
                        comparisonResult = -1 * thisDate.compareTo(nextDate);
                    }
                    else {
                        comparisonResult = -1 * Boolean.compare(doesThisContainR, doesNextContainR);
                    }

                    return comparisonResult;
                });
        return sortedDatesStream.toList();
    }
}
