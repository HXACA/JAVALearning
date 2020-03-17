import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/17 8:37
 */

class ShareResources{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();
        try{
            while(number!=1){
                condition1.await();
            }
            for(int i=0;i<1;i++){
                System.out.println(Thread.currentThread().getName() +" a");
            }
            number = 2;
            condition2.signal();
        }finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        lock.lock();
        try{
            while(number!=2){
                condition2.await();
            }
            for(int i=0;i<2;i++){
                System.out.println(Thread.currentThread().getName() +" b");
            }
            number = 3;
            condition3.signal();
        }finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        lock.lock();
        try{
            while(number!=3){
                condition3.await();
            }
            for(int i=0;i<3;i++){
                System.out.println(Thread.currentThread().getName() +" c");
            }
            number = 1;
            condition1.signal();
        }finally {
            lock.unlock();
        }
    }
}

public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResources shareResources = new ShareResources();
        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                shareResources.print5();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                shareResources.print10();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                shareResources.print15();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C").start();
    }
}
