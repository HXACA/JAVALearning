package decorator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 10:10
 */
public class Chocolate extends Decorator {

    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3);
    }


}
