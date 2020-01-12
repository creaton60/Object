package study.book.object.movie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import study.book.object.movie.policy.DiscountPolicy;

import java.math.BigDecimal;
import java.time.Duration;

@Getter @Setter
@ToString
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
