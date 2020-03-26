package facade;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 13:18
 */
public class MainClass {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.ready();
        facade.play();
        facade.close();
    }
}
