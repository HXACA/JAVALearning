package Builder;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 16:23
 */
public class MainClass {
    public static void main(String[] args) {
        HouseBuilder builder = new PingFangBuilder();
        HouseDirector director = new HouseDirector(builder);
        director.makeHosuse();
        House house = builder.getHouse();
        System.out.println(house);
    }
}
