package adapter.objectadapter;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 8:53
 */
public class MainClass {
    public static void main(String[] args) {
        VoltageAdapter voltageAdapter = new VoltageAdapter(new Voltage220V());
        Phone phone = new Phone();
        phone.charging(voltageAdapter);
    }
}
