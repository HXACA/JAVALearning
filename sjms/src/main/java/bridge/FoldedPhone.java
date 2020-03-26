package bridge;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 9:38
 */
public class FoldedPhone extends Phone {

    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    void open() {
        super.open();
        System.out.println(" 折叠式手机");
    }

    @Override
    void close() {
        super.close();
        System.out.println(" 折叠式手机");
    }

    @Override
    void call() {
        super.call();
        System.out.println(" 折叠式手机");
    }
}
