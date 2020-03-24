package Builder;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 16:23
 */
public class House {
    private String floor;
    private String wall;
    private String ceil;

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getCeil() {
        return ceil;
    }

    public void setCeil(String ceil) {
        this.ceil = ceil;
    }

    @Override
    public String toString() {
        return "House{" +
                "floor='" + floor + '\'' +
                ", wall='" + wall + '\'' +
                ", ceil='" + ceil + '\'' +
                '}';
    }
}
