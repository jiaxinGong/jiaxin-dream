package populate;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import model.Dish;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/21 17:10
 */
public class PopulateTest {

    public static void main(String[] args) {
        Dish dish = new Dish();
        dish.setCalories(100);
        dish.setName("西红柿");
        dish.setType("蔬菜");
        Set<String> set = new HashSet<>();
//        set.add("name");
        set.add("type");
        set.add("calories");
        copyNeedValue(dish,set);
        System.out.println(JSON.toJSONString(dish));
        System.out.println(JSON.toJSONString(copyNeedValue(dish,set)));
    }
    /**
     * 拷贝需要/指定的值
     * @param oldObj
     * @param valueNames
     */
    private static Object copyNeedValue(Object oldObj, Set<String> valueNames) {
        try {
            BeanMap beanMap = new org.apache.commons.beanutils.BeanMap(oldObj);
            Map<String, Object> mapResult = new HashMap<>();
            beanMap.forEach((k, v) -> {
                if (valueNames.contains(k.toString())) {
                    mapResult.put(k.toString(), v);
                }
            });
            Object newObj =  oldObj.getClass().newInstance();
            org.apache.commons.beanutils.BeanUtils.populate(newObj, mapResult);
            return newObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
