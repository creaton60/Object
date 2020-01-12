package study.book.object.movie;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import study.book.object.movie.condition.PeriodCondition;
import study.book.object.movie.condition.SequenceCondition;
import study.book.object.movie.policy.AmountDiscountPolicy;
import study.book.object.movie.policy.PercentDiscountPolicy;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

@Slf4j
class MovieTest {

    @DisplayName("영화 예매 할인량 정책 테스트")
    @ParameterizedTest
    @CsvSource({
            "아바타,120,10000,800,1,10,10,0,11,59,10,0,20,59"
    })
    void testMovieApplicationAmountDiscountPolicy(ArgumentsAccessor arguments) {
        Movie avatar = new Movie(
                arguments.getString(0),
                Duration.ofMinutes(arguments.getInteger(1)),
                Money.wons(arguments.getLong(2)),
                new AmountDiscountPolicy(Money.wons(arguments.getLong(3)),
                        new SequenceCondition(arguments.getInteger(4)),
                        new SequenceCondition(arguments.getInteger(5)),
                        new PeriodCondition(DayOfWeek.MONDAY,
                                LocalTime.of(arguments.getInteger(6), arguments.getInteger(7)),
                                LocalTime.of(arguments.getInteger(8), arguments.getInteger(9))),
                        new PeriodCondition(DayOfWeek.THURSDAY,
                                LocalTime.of(arguments.getInteger(10), arguments.getInteger(11)),
                                LocalTime.of(arguments.getInteger(12), arguments.getInteger(13))))
        );

        log.info("[Movie Info] :: {}", avatar.toString());
    }

    @DisplayName("영화 예매 할인률 정책 테스트")
    @ParameterizedTest
    @CsvSource({
            "타이타닉,180,11000,0.1,14,0,16,59,2,10,0,13,59"
    })
    void testMovieApplicationPercentDiscountPoilcy(ArgumentsAccessor arguments) {
        Movie titanic = new Movie(
                arguments.getString(0),
                Duration.ofMinutes(arguments.getLong(1)),
                Money.wons(arguments.getLong(2)),
                new PercentDiscountPolicy(arguments.getDouble(3),
                        new PeriodCondition(DayOfWeek.TUESDAY,
                                LocalTime.of(arguments.getInteger(4), arguments.getInteger(5)),
                                LocalTime.of(arguments.getInteger(6), arguments.getInteger(7))),
                        new SequenceCondition(arguments.getInteger(8)),
                        new PeriodCondition(DayOfWeek.THURSDAY,
                                LocalTime.of(arguments.getInteger(9), arguments.getInteger(10)),
                                LocalTime.of(arguments.getInteger(11), arguments.getInteger(12))))
        );

        log.info("[Movie Info] :: {}", titanic.toString());
    }
}
