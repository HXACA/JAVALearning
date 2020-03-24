package TestFactory;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 15:41
 */
public class AddOperation extends Operation {
    @Override
    public double getResult() {
        return this.getNum1() + this.getNum2();
    }
}
