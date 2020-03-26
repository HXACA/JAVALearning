package facade;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 13:14
 */
public class DVDPlayer {
    private static DVDPlayer instance = new DVDPlayer();

    private DVDPlayer() {
    }

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on(){
        System.out.println("dvd on");
    }

    public void close(){
        System.out.println("dvd close");
    }

    public void play(){
        System.out.println("dvd play");
    }
}
