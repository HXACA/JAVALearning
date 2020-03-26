package facade;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 13:19
 */
public class Facade {
    private DVDPlayer dvdPlayer;
    private Popcorn popcorn;
    private Projector projector;

    public Facade() {
        this.dvdPlayer = DVDPlayer.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.projector = Projector.getInstance();
    }

    public void ready(){
        popcorn.on();
        popcorn.play();
        projector.on();
        dvdPlayer.on();
    }

    public void play(){
        dvdPlayer.play();
    }

    public void close(){
        dvdPlayer.close();
        projector.close();
        popcorn.close();
    }



}
