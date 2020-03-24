package Builder;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 16:25
 */
public class PingFangBuilder implements HouseBuilder {

    House house = new House();

    @Override
    public void makeFloor() {
        house.setFloor("平房的地板");
    }

    @Override
    public void makeWall() {
        house.setWall("平房的墙");
    }

    @Override
    public void makeCeil() {
        house.setCeil("平房的天花板");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
