package staticproxy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 14:06
 */
public class MainClass {
    public static void main(String[] args) {
        TeachDao teachDao = new TeachDao();
        TeachDaoProxy teachDaoProxy = new TeachDaoProxy(teachDao);
        teachDaoProxy.teach();
    }
}
