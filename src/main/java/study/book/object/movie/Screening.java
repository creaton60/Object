package study.book.object.movie;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class Screening {
    private Movie movie;
    private int sequece;
    private LocalDateTime whenScreened;
}
