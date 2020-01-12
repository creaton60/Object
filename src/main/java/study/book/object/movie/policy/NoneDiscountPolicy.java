package study.book.object.movie.policy;

import lombok.ToString;
import study.book.object.movie.Money;
import study.book.object.movie.Screening;

@ToString
public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
