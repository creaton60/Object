package study.book.object.movie;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequece;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequece = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequece == sequece;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this);
    }
}
