package flyweight;

import java.util.Hashtable;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 13:45
 */
public class WebSiteFactory {
    private Hashtable<String,ConcreteWebSite> pool = new Hashtable<>();

    public WebSite getWebSiteCategory(String type){
        if(!pool.containsKey(type)){
            pool.put(type,new ConcreteWebSite(type));
        }
        return pool.get(type);
    }

    public int getCount(){
        return pool.size();
    }

}
