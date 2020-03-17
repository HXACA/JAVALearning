import java.util.concurrent.TimeUnit;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/17 8:53
 */

class Phone{
    public static synchronized void SendEmail(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----Email");
    }
    public  synchronized void SendSMS(){
        System.out.println("----SMS");
    }
    public void hello(){
        System.out.println("hello");
    }
}

public class Lock8 {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone1.SendEmail();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone2.SendSMS();
        },"A").start();

    }
}
