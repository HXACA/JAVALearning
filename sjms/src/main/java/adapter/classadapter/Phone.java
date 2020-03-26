package adapter.classadapter;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 8:44
 */
public class Phone {
    public void charging(Voltage5V voltage5V){
        if(voltage5V.output5V() == 5)
            System.out.println("开始充电");
        else
            System.out.println("无法充电");
    }
}
