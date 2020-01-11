package study.book.object.ticket.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 관람객 Model
 */
@Getter @Setter
@ToString
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }
}
