package staticproxy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 14:07
 */
public class TeachDaoProxy implements ITeachDao {

    private ITeachDao target;

    public TeachDaoProxy(ITeachDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("我来代理");
        target.teach();
        System.out.println("代理结束");
    }
}
