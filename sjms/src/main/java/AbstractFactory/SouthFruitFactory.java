package AbstractFactory;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 15:29
 */
public class SouthFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new SouthApple();
    }

    @Override
    public Fruit getBanana() {
        return new SouthBanana();
    }
}
