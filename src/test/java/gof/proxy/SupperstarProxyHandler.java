package gof.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 * 代理
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/26 16:53
 */
public class SupperstarProxyHandler implements InvocationHandler {

    private Supperstar supperstar;

    public SupperstarProxyHandler(Supperstar supperstar){
        this.supperstar = supperstar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前后添加功能
        System.out.println(method.getName());
        Object result = method.invoke(supperstar, args);
        // 前后添加功能
        return result;
    }
}
