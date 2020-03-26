package adapter.classadapter;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 8:43
 */
public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        int src = output220V();
        System.out.println("降压处理");
        return 5;
    }
}
