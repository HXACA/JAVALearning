package Builder;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 16:25
 */
public interface HouseBuilder {
    void makeFloor();
    void makeWall();
    void makeCeil();

    House getHouse();

}
