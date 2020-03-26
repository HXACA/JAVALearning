package flyweight;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 13:48
 */
public class MainClass {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();
        WebSite news = factory.getWebSiteCategory("新闻");
        news.use(new User("liuxin"));
        WebSite news2 = factory.getWebSiteCategory("新闻");
        news2.use(new User("tom"));
        System.out.println(factory.getCount());
        WebSite blog = factory.getWebSiteCategory("博客");
        blog.use(new User("jerry"));
        System.out.println(factory.getCount());
    }
}
