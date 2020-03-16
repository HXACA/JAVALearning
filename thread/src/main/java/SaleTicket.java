/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/16 17:46
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(30);
        new Thread(() -> {
            for (int i = 0; i < 40; i++)
                ticket.saleTicket();
        }, "A").start();

        new Thread( () -> {
            for (int i = 0; i < 40; i++)
                ticket.saleTicket();
        },"B").start();
        new Thread( () -> {
            for (int i = 0; i < 40; i++)
                ticket.saleTicket();
        },"C").start();
    }
}

