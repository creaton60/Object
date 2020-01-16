package study.book.object.movie.condition;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter @Setter
@ToString
public class DiscountCondition {
    private DiscountConditionType type;

    private int sequence;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
