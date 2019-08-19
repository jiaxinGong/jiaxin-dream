package gof.builder;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 22:48
 */
public class Product {

    private List<Object> parts = new ArrayList<>();

    public void addPart(Object part) {
        parts.add(part);
    }

    public void show(){
        System.out.println(JSON.toJSONString(parts));
    }

}
