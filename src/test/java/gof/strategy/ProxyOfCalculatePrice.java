package gof.strategy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;
import java.util.SortedMap;

/**
 * <p>
 * 计价器代理
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/28 23:44
 */
public class ProxyOfCalculatePrice implements InvocationHandler {

    private SortedMap<Integer, Class<? extends CalculatePrice>> priceMap;

    private ProxyOfCalculatePrice(SortedMap<Integer, Class<? extends CalculatePrice>> priceMap) {
        this.priceMap = priceMap;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Objects.equals("calculate", method.getName())) {
            Double price = 0D;
            for (Class<? extends CalculatePrice> clazz : priceMap.values()) {
                if (price == 0) {
                    price = (Double) method.invoke(clazz.newInstance(), args);
                } else {
                    price = (Double) method.invoke(clazz.newInstance(), price);
                }
            }
            return price;
        }
        return null;
    }

    public static CalculatePrice getProxy(SortedMap<Integer, Class<? extends CalculatePrice>> priceMap) {
        return (CalculatePrice) Proxy
            .newProxyInstance(ProxyOfCalculatePrice.class.getClassLoader(), new Class[]{CalculatePrice.class},
                new ProxyOfCalculatePrice(priceMap));
    }

}
