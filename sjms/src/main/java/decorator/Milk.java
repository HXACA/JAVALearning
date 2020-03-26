package decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 10:13
 */
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(5);
    }
}
