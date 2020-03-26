package facade;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 13:14
 */
public class Projector {
    private static Projector instance = new Projector();

    private Projector() {
    }

    public static Projector getInstance() {
        return instance;
    }

    public void on(){
        System.out.println("projector on");
    }

    public void close(){
        System.out.println("projector close");
    }

    public void play(){
        System.out.println("rojector foucus");
    }
}
