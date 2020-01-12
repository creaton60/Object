package study.book.object.movie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter @Setter
@ToString
public class Movie {
    private Money fee;

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(new Money(BigDecimal.ZERO));
    }
}
