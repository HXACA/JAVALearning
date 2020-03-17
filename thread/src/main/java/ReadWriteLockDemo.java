import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/17 13:35
 */

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"开始写入");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"结束写入");
        readWriteLock.writeLock().unlock();
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"开始读取");
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName()+"结束读取 "+result);
        readWriteLock.readLock().unlock();
    }

}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for(int i=0;i<5;i++){
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myCache.put(temp+"",temp+"");
                }
            },"input"+String.valueOf(i)).start();
        }

        for(int i=0;i<5;i++){
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myCache.get(temp+"");
                }
            },"read"+String.valueOf(i)).start();
        }

    }
}
