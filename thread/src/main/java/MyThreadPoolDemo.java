import java.util.concurrent.*;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/17 15:15
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {


        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                new ThreadPoolExecutor.DiscardPolicy());
        for(int i=0;i<12;i++){
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        threadPool.shutdown();

    }
}

