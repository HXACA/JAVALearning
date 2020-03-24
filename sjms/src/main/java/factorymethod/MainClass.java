package factorymethod;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 14:42
 */
public class MainClass {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        FruitFactory fruitFactory = new AppleFactory();
        Apple apple = (Apple) fruitFactory.getFruit();
        apple.get();

    }
}
