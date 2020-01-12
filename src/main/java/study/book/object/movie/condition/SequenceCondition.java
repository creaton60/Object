package study.book.object.movie.condition;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import study.book.object.movie.Screening;

@Slf4j
public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
