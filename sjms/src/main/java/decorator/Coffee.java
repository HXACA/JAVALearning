package decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 10:05
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
