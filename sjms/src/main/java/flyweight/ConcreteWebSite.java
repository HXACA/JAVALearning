package flyweight;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 13:43
 */
public class ConcreteWebSite extends WebSite {

    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为"+type);
        System.out.println(user.getName());
    }

}
