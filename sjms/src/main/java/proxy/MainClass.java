package proxy;

import staticproxy.TeachDaoProxy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 14:06
 */
public class MainClass {
    public static void main(String[] args) {
       ProxyFactory factory = new ProxyFactory(new TeachDao());
       ITeachDao teachDao = (ITeachDao) factory.getTarget();
       teachDao.teach();
        System.out.println(teachDao.who("liuxin"));
    }
}
