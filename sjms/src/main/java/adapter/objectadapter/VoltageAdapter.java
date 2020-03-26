package adapter.objectadapter;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 8:43
 */
public class VoltageAdapter implements Voltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int src = voltage220V.output220V();
        System.out.println("降压处理");
        return 5;
    }
}
