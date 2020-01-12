package study.book.object.movie.condition;

import study.book.object.movie.Screening;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
