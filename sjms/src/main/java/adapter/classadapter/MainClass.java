package adapter.classadapter;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 8:38
 */
public class MainClass {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
