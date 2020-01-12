package study.book.object.ticket.service;

import study.book.object.ticket.model.Audience;
import study.book.object.ticket.model.TicketSeller;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }

}
