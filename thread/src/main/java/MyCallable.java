import java.util.concurrent.Callable;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/11 22:56
 */
public class MyCallable implements Callable {
    private int num = 10;
    public Object call() throws Exception {
        num--;
        System.out.println(Thread.currentThread().getName() + ":" + num);
        return num;
    }
}

