package Decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 17:56
 */
public class SwimCarDecorator extends CarDecorator {

    public SwimCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void show() {
        getCar().show();
        swim();
    }

    public void swim(){
        System.out.println("可以游");
    }
}
