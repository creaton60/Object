package study.book.object.movie.policy;

import lombok.ToString;
import study.book.object.movie.Money;
import study.book.object.movie.Screening;
import study.book.object.movie.condition.DiscountCondition;

@ToString
public class PercentDefaultDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDefaultDiscountPolicy(double percent, DiscountCondition... conditions){
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
