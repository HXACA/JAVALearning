package staticproxy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 14:07
 */
public class TeachDao implements ITeachDao {
    @Override
    public void teach() {
        System.out.println("teach");
    }
}
