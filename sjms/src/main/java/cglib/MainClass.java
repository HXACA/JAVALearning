package cglib;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 14:28
 */
public class MainClass {
    public static void main(String[] args) {
        TeachDao teachDao = new TeachDao();
        ProxyFactory factory = new ProxyFactory(teachDao);
        TeachDao target = (TeachDao) factory.getTarget();
        target.teach();

    }
}
