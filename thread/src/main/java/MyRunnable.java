import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/11 22:52
 */
public class MyRunnable implements Runnable {
    private Integer num = 10;

    ReentrantLock lock = new ReentrantLock();

    public void run() {

        lock.lock();
        try {
            if (num >= 1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num--;
                System.out.println(Thread.currentThread().getName() + ":" + num);
            } else {
                System.out.println("fail");
            }
        } finally {
            lock.unlock();
        }
    }
}
