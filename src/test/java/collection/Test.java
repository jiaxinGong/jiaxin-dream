package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

    @org.junit.Test
    public void testSubList() {
        List list = new ArrayList(16);
        list.add("a");
        list.add("b");
        list.add("c");
        List list2 = list.subList(0, 2);
        list.add("e");
        list.remove("a");
        System.out.println(list);
        for (Object obj : list2) {
            System.out.println(obj);
        }
    }

    @org.junit.Test
    public void testAddOrRemove() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String str : list) {
            if ("2".equals(str)) {
                list.remove(str);
            }
        }
        System.out.println(list);
    }

    @org.junit.Test
    public void testForeachMap() {
        Map<String, String> map = new HashMap<>(16);
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        for (Entry entry : map.entrySet()) {
            System.out.println("k:" + entry.getKey() + " v:" + entry.getValue());
        }
        System.out.println("=====================");
        map.forEach((k, v) -> {
            System.out.print("k:" + k);
            System.out.println(" v:" + v);
        });


    }
}
