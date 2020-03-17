import java.util.concurrent.Semaphore;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/17 13:07
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for(int i=0;i<6;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " 抢到了");
                        Thread.sleep(3000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                }
            },String.valueOf(i)).start();
        }
    }
}
