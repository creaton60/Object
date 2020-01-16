package study.book.object.movie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class Screening {
    private Movie movie;
    private int sequece;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequece = sequence;
        this.whenScreened = whenScreened;
    }

    public Money calculateFee(int audienceCount) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                if(movie.isDiscountable(whenScreened, sequece)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount);
                }
                break;
            case PERCENT_DISCOUNT:
                if(movie.isDiscountable(whenScreened, sequece)) {
                    return movie.calculatePercentDiscountFee().times(audienceCount);
                }
                break;
            case NONE_DISCOUNT:
                return movie.calculateNoneDiscountFee().times(audienceCount);
        }

        return movie.calculateNoneDiscountFee().times(audienceCount);
    }
}
