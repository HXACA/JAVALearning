package Decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 17:47
 */
public abstract class CarDecorator implements Car {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarDecorator(Car car) {
        this.car = car;
    }

    public abstract void show();

}
