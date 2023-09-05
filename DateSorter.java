import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 * Implement in single class.
 */
public class DateSorter {
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
        List<LocalDate> result = new ArrayList<>(unsortedDates); //not deep copy, elements inside are referenced
        Comparator<LocalDate> lambdaCompare = (x, y) -> {
            int cmp;
            boolean doesContainRx = x.getMonth().toString().contains("r");
            boolean doesContainRy = x.getMonth().toString().contains("r");
            if(doesContainRx) {
                if(!doesContainRy || y.isBefore(x)) {
                    cmp = -1;
                }
                else {
                    cmp = 1;
                }
            }
            else if(!y.isBefore(x)) {
                cmp = -1;
            }
            else {
                cmp = 1;
            }
            return cmp;
        };
        result.sort(lambdaCompare);
        return result;
    }
}
