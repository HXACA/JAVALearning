package simplefactory;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 14:42
 */
public class MainClass {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        FruitFactory fruitFactory = new FruitFactory();

        Fruit apple = fruitFactory.getFruit("simplefactory.Apple");
        Fruit banana = fruitFactory.getFruit("simplefactory.Banana");
        apple.get();
        banana.get();
    }
}
