package AbstractFactory;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 15:31
 */
public class MainClass {
    public static void main(String[] args) {
        FruitFactory ff = new NorthFruitFactory();
        Fruit apple = ff.getApple();
        apple.get();
        ff = new SouthFruitFactory();
        apple = ff.getApple();
        apple.get();
    }
}
