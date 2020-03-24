package Decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 17:42
 */
public class MainClass {
    public static void main(String[] args) {
        Car car = new RunCar();
        car.show();
        Car flyCar = new FlyCarDecorator(car);
        flyCar.show();
        CarDecorator swimCar = new SwimCarDecorator(flyCar);
        swimCar.show();
    }
}
