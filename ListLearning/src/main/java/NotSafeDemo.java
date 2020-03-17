import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/17 9:48
 */
public class NotSafeDemo  {
    public static void main(String[] args) {
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                public void run() {
                    list.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(Thread.currentThread().getName()+ " " + list);
                }
            },String.valueOf(i)).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
