package Decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 17:48
 */
public class FlyCarDecorator extends CarDecorator {

    public FlyCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void show() {
        getCar().show();
        fly();
    }

    public void fly(){
        System.out.println("可以飞");
    }
}
