package TestStrategy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 19:26
 */
public class MainClass {
    public static void main(String[] args) {
        Context context = new Context(new StrategyB());
        System.out.println(context.cost(200));
    }
}
