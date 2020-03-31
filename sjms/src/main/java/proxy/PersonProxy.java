package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/30 18:41
 */
public class PersonProxy {
    public Object object;

    public PersonProxy(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("经纪人介绍一下");
                Object invoke = method.invoke(object, args);
                System.out.println("经纪人介绍完了");
                return invoke;
            }
        });
    }
}
