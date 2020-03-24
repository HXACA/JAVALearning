package Builder;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 16:32
 */
public class HouseDirector {
    private HouseBuilder builder;

    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }

    public void makeHosuse(){
        builder.makeCeil();
        builder.makeFloor();
        builder.makeWall();
    }

}
