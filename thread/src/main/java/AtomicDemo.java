import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/19 16:19
 */



public class AtomicDemo {
    static AtomicReference<Integer>atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference(100,1);
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet(100,2019);
            System.out.println(atomicReference.get());
        },"t2").start();

        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println("t3的第一次版本号 " + stamp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(100,101,stamp,stamp+1);
            stamp = stampedReference.getStamp();
            System.out.println("t3的第二次版本号 " + stamp);
            stampedReference.compareAndSet(101,100,stamp,stamp+1);
            stamp = stampedReference.getStamp();
            System.out.println("t3的第三次版本号 " + stamp);

        },"t3").start();

        new Thread(()->{
            int stamp = stampedReference.getStamp();
            System.out.println("t4的第一次版本号 " + stamp);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(stampedReference.compareAndSet(100,101,stamp,stamp+1));
            System.out.println(stampedReference.getReference() + " "+ stampedReference.getStamp());
        },"t4").start();

        Thread.sleep(10*1000);
    }
}
