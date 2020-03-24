package Strategy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 19:18
 */
public class MainClass {
    public static void main(String[] args) {
        Context context = new Context(new MD5Strateggy());
        context.encrypt();
    }
}
