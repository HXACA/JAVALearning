package Decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 17:39
 */
public class RunCar implements Car {
    @Override
    public void show() {
        run();
    }

    public void run(){
        System.out.println("可以跑");
    }
}
