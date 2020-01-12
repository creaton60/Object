package study.book.object.ticket.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    /**
     * Bag Instance 의 상태는
     * 현금과 초대장을 함께 보관하거나, 초대장 없이 보관하는 두가지
     * 이 두가지를 인스턴스 생성 시점에 강제한다.
     * @param amount 현금 보유량
     */
    public Bag(long amount) {
        this(null, amount);
    }

    public Long hold(Ticket ticket) {
        if(hasInvitation()) {
            setTicket(ticket);

            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    /**
     * Bag 생성시 초대장과 현금보유량으로 생성규정
     *
     * @param invitation 초대장
     * @param amount 현금 보유량
     */
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket !=null;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
