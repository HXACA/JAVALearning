import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/16 17:51
 */



public class Ticket {

    private  int number;

    public Ticket(int number) {
        this.number = number;
    }

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void saleTicket(){
        try{
            reentrantLock.lock();
            if(number>0){
                System.out.println(Thread.currentThread().getName() + " " + number);
                number--;
            }
        }finally {
            reentrantLock.unlock();
        }
    }

}
