package template;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/30 14:44
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("花生豆浆");
        SoyaMilk milk = new PeanutSoyaMilk();
        milk.make();
    }
}
