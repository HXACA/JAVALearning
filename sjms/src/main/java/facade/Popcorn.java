package facade;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 13:14
 */
public class Popcorn {
    private static Popcorn instance = new Popcorn();

    private Popcorn() {
    }

    public static Popcorn getInstance() {
        return instance;
    }

    public void on(){
        System.out.println("popcorn on");
    }

    public void close(){
        System.out.println("popcorn close");
    }

    public void play(){
        System.out.println("popcorn is poping");
    }
}
