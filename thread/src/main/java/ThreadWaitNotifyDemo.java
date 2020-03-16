import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/16 18:55
 */

class P {
    private int number = 0;
    static int sum = 0;
    private Lock lock= new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0)
                condition.await();
            number++;
            System.out.println(Thread.currentThread().getName() + " " + number);
            sum++;
            //System.out.println(sum);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws InterruptedException {
        lock.lock();

        try{
            while (number == 0)
                condition.await();
            number--;
            System.out.println(Thread.currentThread().getName() + " " + number);
            sum++;
            //System.out.println(sum);
            condition.signalAll();
        }finally {
           lock.unlock();
        }

    }

//    public synchronized void increment() throws InterruptedException {
//        while (number != 0)
//            this.wait();
//        number++;
//        System.out.println(Thread.currentThread().getName() + " " + number);
//        sum++;
//        System.out.println(sum);
//        this.notifyAll();
//    }
//
//    public synchronized void decrement() throws InterruptedException {
//        while (number == 0)
//            this.wait();
//        number--;
//        System.out.println(Thread.currentThread().getName() + " " + number);
//        sum++;
//        System.out.println(sum);
//        this.notifyAll();
//    }
}


public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        P p = new P();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    p.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    p.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    p.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    p.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}
