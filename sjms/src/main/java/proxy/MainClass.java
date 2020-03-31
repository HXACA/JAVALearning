package proxy;

import staticproxy.TeachDaoProxy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 14:06
 */
public class MainClass {
    public static void main(String[] args) {
       PersonProxy personProxy = new PersonProxy(new Girl());
       Person person = (Person) personProxy.getObject();
        System.out.println(person.dating(1.8));
    }
}
