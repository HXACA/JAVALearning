import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/19 15:21
 */

class VP{
    volatile int a = 0;
    AtomicInteger atomicInteger = new AtomicInteger();
    public void add(){
        this.a++;
    }

    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }

}



public class volatileDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        VP p = new VP();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p.add();
                p.addAtomic();
                countDownLatch.countDown();
                //System.out.println(Thread.currentThread().getName() + " " + p.a);
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(p.a);
        System.out.println(p.atomicInteger.get());
        System.out.println("结束");
    }

}
