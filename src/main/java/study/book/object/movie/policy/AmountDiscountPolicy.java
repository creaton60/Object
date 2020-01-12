package study.book.object.movie.policy;

import study.book.object.movie.Money;
import study.book.object.movie.Screening;
import study.book.object.movie.condition.DiscountCondition;

public class AmountDiscountPolicy extends DiscountPolicy{
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
