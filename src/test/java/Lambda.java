import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Dish;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambda {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
//        int n = numbers.stream().reduce(0,(a,b)->a+b);
        int n = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum:" + n);
        int max = numbers.stream().reduce(0, Integer::max);
        System.out.println("max:" + max);
    }

    /**
     * 测试整数
     */
    @Test
    public void testInt() {
        double[] doubles = {2.1, 3, 4};
        Arrays.stream(doubles).filter(a -> Math.sqrt(a * a) % 1 == 0).forEach(System.out::println);
    }

    @Test
    public void testRange() {
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
    }

    @Test
    public void testPythagoreanTriples() {
        Stream<double[]> as = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)}))
                .filter(t -> t[2] % 1 == 0);
        as.forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
    }

    @Test
    public void testFileStream() {
        try (Stream<String> lines = Files.lines(Paths.get("D:/data.txt"), Charset.defaultCharset())) {
            long count = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
            System.out.println("count:" + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStreamGenerate() {
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
    }

    @Test
    public void testFBN() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(10).map(t -> t[0]).forEach(System.out::println);
    }

    @Test
    public void testGroupBy() {
        List<Dish> menu = new ArrayList<>();
        Dish qk = new Dish("秋葵", "蔬菜", 200);
        Dish nr = new Dish("牛肉", "肉类", 800);
        Dish zr = new Dish("猪肉", "肉类", 500);
        Dish bc = new Dish("白菜", "蔬菜", 400);
        Dish bsy = new Dish("巴沙鱼", "鱼类", 600);
        menu.add(qk);
        menu.add(nr);
        menu.add(zr);
        menu.add(bc);
        menu.add(bsy);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(Collectors.groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));

        System.out.println(dishesByCaloricLevel.toString());

        System.out.println("==============================");

        Map<String, Long> typeNums = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println("typeNums:" + typeNums);

        System.out.println("==============================");
        Map<String, Optional<Dish>> maxBy = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println("maxBy:" + maxBy);

        System.out.println("==============================");
        Map<String, Dish> mostCaloricByThen = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println("mostCaloricByThen:" + mostCaloricByThen);
        System.out.println("==============================");
        Map<String, Integer> totalCaloricByType = menu.stream().collect(
                Collectors.groupingBy(
                        Dish::getType, Collectors.summingInt(Dish::getCalories)
                )
        );
        System.out.println("totalCaloricByType:" + totalCaloricByType);
        System.out.println("==============================");

        Map<String, Set<CaloricLevel>> caloricLevelByType = menu.stream().collect(
                Collectors.groupingBy(
                        Dish::getType, Collectors.mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                },
//                                Collectors.toSet()
                                Collectors.toCollection(HashSet::new)
                        )
                )
        );
        System.out.println("caloricLevelByType:" + caloricLevelByType);
    }

    @Test
    public void testIterface(){
        System.out.println(this.combiner().toString());
    }

    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> map1,Map<Boolean, List<Integer>> map2) ->{
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Test
    public void testCollectorHarness(){
        long fastTest = Long.MAX_VALUE;
        for(int i = 0;i<10;i++){
            long start =System.nanoTime();
            IntStream.rangeClosed(2,100_000_00).boxed().collect(new PrimeNumbersCollector());
            long duration = (System.nanoTime() - start ) / 1000_000;
            if(duration <  fastTest){
                fastTest = duration;
            }
            System.out.println("i:"+i+",duration:"+duration);
        }
        System.out.println("fastTest:"+fastTest);
    }

    @Test
    public void caculateBirthDay() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("2018-07-18 00:00:00");

        Date birthDay =  DateUtils.addDays(date,266);
        System.out.println(dateFormat.format(birthDay));
    }
    public enum CaloricLevel {DIET, NORMAL, FAT}
}
