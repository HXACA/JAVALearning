package AbstractFactory;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 15:29
 */
public class NorthFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new NorthApple();
    }

    @Override
    public Fruit getBanana() {
        return new NorthBanana();
    }
}
