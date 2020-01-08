package study.book.object.ticket.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class Invitation {
    private LocalDateTime when;
}
