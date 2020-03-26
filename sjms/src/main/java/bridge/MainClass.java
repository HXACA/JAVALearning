package bridge;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 9:41
 */
public class MainClass {
    public static void main(String[] args) {
        Phone foldVivo = new FoldedPhone(new Vivo());
        Phone foldXiaomi = new FoldedPhone(new XiaoMi());
        foldVivo.open();
        foldXiaomi.open();
    }
}
