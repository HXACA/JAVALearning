package bridge;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 9:37
 */
public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    void open(){
        brand.open();
    }

    void close(){
        brand.close();
    }

    void call(){
        brand.call();
    }
}
