package study.book.object.movie.condition;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import study.book.object.movie.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Slf4j
@ToString
public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <=0 &&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >=0;
    }
}
