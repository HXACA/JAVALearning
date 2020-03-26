package cglib;


/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 14:07
 */
public class TeachDao {

    public void teach() {
        System.out.println("teach");
    }

    public String who(String name) {
        return "I am " + name;
    }
}
