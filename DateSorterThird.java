import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
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
    private static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter
            .ofPattern("MMMM", Locale.US);
    private static final char DEFAULT_CHARACTER = 'r';

    private final DateTimeFormatter dateTimeFormatter;

    private final char character;

    public DateSorterThird() {
        this.dateTimeFormatter = DEFAULT_DATE_TIME_FORMATTER;
        this.character = DEFAULT_CHARACTER;
    }

    public DateSorterThird(DateTimeFormatter dateTimeFormatter, char character) {
        this.dateTimeFormatter = dateTimeFormatter;
        this.character = character;
    }

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        if (unsortedDates == null) {
            throw new IllegalArgumentException("List<LocalDate> unsortedDates must not be null");
        }
        if (unsortedDates.size() < 2) {
            return unsortedDates;
        }

        return unsortedDates.stream()
                .sorted(this::compareDatesDependingOnCharacter)
                .toList();
    }

    private int compareDatesDependingOnCharacter(LocalDate thisDate, LocalDate nextDate) {
        if (thisDate == null) {
            throw new IllegalArgumentException("LocalDate thisDate must not be null");
        }
        if (nextDate == null) {
            throw new IllegalArgumentException("LocalDate nextDate must not be null");
        }

        boolean doesThisContainR = checkIfMonthContainsCharacter(thisDate);
        boolean doesNextContainR = checkIfMonthContainsCharacter(nextDate);

        if (doesThisContainR && doesNextContainR) {
            return thisDate.compareTo(nextDate);
        }
        if (!doesThisContainR && !doesNextContainR) {
            return nextDate.compareTo(thisDate);
        }

        return Boolean.compare(doesNextContainR, doesThisContainR);
    }

    private String getMonthName(LocalDate localDate) {
        return this.dateTimeFormatter.format(localDate);
    }

    private boolean checkIfMonthContainsCharacter(LocalDate localDate) {
        return getMonthName(localDate).contains(String.valueOf(this.character));
    }
}
