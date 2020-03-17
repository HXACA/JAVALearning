import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/17 13:59
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String>blockingQueue = new ArrayBlockingQueue<>(3);
        for(int i=0;i<10;i++){
            System.out.println(blockingQueue.add("a"));
        }
    }
}
