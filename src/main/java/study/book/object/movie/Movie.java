package study.book.object.movie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import study.book.object.movie.policy.DefaultDiscountPolicy;
import study.book.object.movie.policy.DiscountPolicy;

import java.time.Duration;

@Getter @Setter
@ToString
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy defaultDiscountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy defaultDiscountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.defaultDiscountPolicy = defaultDiscountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(defaultDiscountPolicy.calculateDiscountAmount(screening));
    }
}
