package study.book.object.movie.policy;

import study.book.object.movie.Money;
import study.book.object.movie.Screening;
import study.book.object.movie.condition.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy{
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions){
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
