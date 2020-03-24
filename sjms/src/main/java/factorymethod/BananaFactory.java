package factorymethod;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 15:08
 */
public class BananaFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Banana();
    }
}
