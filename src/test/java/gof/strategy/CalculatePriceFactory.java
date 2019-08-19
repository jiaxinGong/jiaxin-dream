package gof.strategy;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import gof.strategy.annotation.OnceValidRegion;
import gof.strategy.annotation.TotalValidRegion;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <p>
 * 获取计价策略工厂
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/28 21:49
 */
public class CalculatePriceFactory {

    private static final String STRATEGY_PACKAGE = "gof.strategy";
    private ClassLoader classLoader = getClass().getClassLoader();
    private List<Class<? extends CalculatePrice>> strategys;

    private CalculatePriceFactory() {
        init();
    }

    public CalculatePrice createCalculatePrice(Customer customer) {
        SortedMap<Integer, Class<? extends CalculatePrice>> priceMap = new TreeMap<>();
        strategys.stream().forEach(strategyClass -> {
            TotalValidRegion totalValidRegion = strategyClass.getDeclaredAnnotation(TotalValidRegion.class);
            System.out.println("totalValidRegion="+ JSON.toJSONString(totalValidRegion));
            if (Objects.nonNull(totalValidRegion)) {
                if (customer.getTotalAmount() >= totalValidRegion.value().min()
                    && customer.getTotalAmount() < totalValidRegion.value().max()) {
                    priceMap.put(totalValidRegion.value().order(), strategyClass);
                }
                return;
            }

            OnceValidRegion onceValidRegion = strategyClass.getDeclaredAnnotation(OnceValidRegion.class);
            System.out.println("onceValidRegion="+ JSON.toJSONString(onceValidRegion));
            if (Objects.nonNull(onceValidRegion)) {
                if(customer.getAmount() > onceValidRegion.value().min()){
                    priceMap.put(onceValidRegion.value().order(), strategyClass);
                }
            }

        });
        return ProxyOfCalculatePrice.getProxy(priceMap);
    }

    public static CalculatePriceFactory getInstance() {
        return CalculatePriceFactoryInstance.instance;
    }

    private void init() {
        strategys = Lists.newArrayList();
        Arrays.stream(getResources()).forEach(file -> {
            try {
                Class<?> clazz = classLoader.loadClass(STRATEGY_PACKAGE+"."+file.getName().replace(".class", ""));
                System.out.println();
                System.out.println("CalculatePrice.class.getName()="+CalculatePrice.class.getName());
                System.out.println("clazz.getName()="+clazz.getName());
                if (CalculatePrice.class.isAssignableFrom(clazz) &&
                    !Objects.equals(CalculatePrice.class.getName(), clazz.getName())) {
                    strategys.add((Class<? extends CalculatePrice>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    //获取扫描的包下面所有的class文件
    private File[] getResources() {
        try {
            File file = new File(classLoader.getResource(STRATEGY_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles((f) -> {
                if (f.getName().endsWith(".class")) {//我们只扫描class文件
                    return true;
                }
                return false;
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

    private static class CalculatePriceFactoryInstance {

        private static CalculatePriceFactory instance = new CalculatePriceFactory();
    }
}
