package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/25 14:17
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(!method.getName().equals("who")){
                    return method.invoke(target,args);
                }
                System.out.println("动态代理哦");
                Object returnVal = method.invoke(target,args);
                System.out.println("代理结束咯");
                return returnVal;
            }
        });
    }
}
