import java.time.LocalDate;

public class DateInterval {
    private final LocalDate from;
    private final LocalDate to;

    public DateInterval(LocalDate from, LocalDate to) {
        if(to.isBefore(from))
            throw new IllegalArgumentException("end date cannot be before start date");
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }
    public boolean overlaps(DateInterval dateInterval){
        return !(this.to.isBefore(dateInterval.from) || this.from.isAfter(dateInterval.to));
    }
}
