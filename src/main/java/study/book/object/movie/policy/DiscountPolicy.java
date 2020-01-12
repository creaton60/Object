package study.book.object.movie.policy;

import study.book.object.movie.Money;
import study.book.object.movie.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
