import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/11 22:47
 */
public class ThreadTest {

    @Test
    public void test1() throws Exception {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.start();
        t2.start();
        t1.run();//顺序执行
        t2.run();
    }

    @Test
    public void test2() throws Exception {
        Runnable runnable = new MyRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    @Test
    public void test3() throws Exception {
        Callable<Integer> callable = new MyCallable();
        FutureTask<Integer>task1 = new FutureTask<Integer>(callable);
        FutureTask<Integer>task2 = new FutureTask<Integer>(callable);
        new Thread(task1).start();
        new Thread(task2).start();
        System.out.println(task1.get());
        System.out.println(task2.get());
    }

    @Test
    public void test4() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        MyRunnable runnable = new MyRunnable();
        pool.submit(runnable);
        pool.submit(runnable);
        pool.submit(runnable);
        Callable<Integer>task = new MyCallable();
        Future<Integer> future = pool.submit(task);
        System.out.println(future.get());

        pool.shutdown();
    }

    @Test
    public void test5() throws Exception{
        MyRunnable runnable = new MyRunnable();
        for(int i=0;i<20;i++){
            new Thread(runnable).start();
        }
        Thread.sleep(100000);
    }
}
