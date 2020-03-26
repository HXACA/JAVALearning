package decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 10:08
 */
public class Decorator extends Drink {
    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        return super.getDes() + obj.getDes();
    }
}
