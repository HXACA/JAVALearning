/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/11 22:49
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(super.getName() + "started");
    }
}
