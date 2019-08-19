package stream;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * <p>
 * 流Map数据操作|提取
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/20 12:02
 */
public class MapOperation {

    @Test
    public void arraysToStream() {
        System.out.println("===============strArray==============");
        String[] strArray = {"hello", "world"};
        List<String> list = Arrays.stream(strArray).collect(Collectors.toList());
        System.out.println(list);
        Arrays.stream(strArray).forEach(s -> {
            System.out.println(s);
        });
        System.out.println("===============intArray==============");
        Integer[] intArray = {1,2,3,4,5,6,7,8};
        Arrays.stream(intArray).forEach(i->{
            System.out.println(i);
        });
    }

    @Test
    public void flatMap(){
        System.out.println("===============String flatMap==============");
        String[] strArray = {"hello", "world"};
        Arrays.stream(strArray).map(s->s.split("")).flatMap(s-> Arrays.stream(s)).forEach(f->{
            System.out.println(f);
        });
        System.out.println("===============two List flatMap==============");
        List<Integer> number1 = Arrays.asList(1,2,3);
        List<Integer> number2 = Arrays.asList(3,4);
        List<int[]> pairs = number1.stream().flatMap(i-> number2.stream().map(j-> new int[]{i,j})).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(pairs));

    }
}
