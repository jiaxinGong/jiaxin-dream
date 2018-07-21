import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
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
                .filter( t-> t[2] %1 == 0);
        as.forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
    }

    @Test
    public void testFileStream(){
        try(Stream<String> lines = Files.lines(Paths.get("D:/data.txt"), Charset.defaultCharset())){
            long  count = lines.flatMap(line-> Arrays.stream(line.split(" "))).distinct().count();
            System.out.println("count:"+count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStreamGenerate(){
        Stream.iterate(0,n-> n+2).limit(10).forEach(System.out::println);
    }

    @Test
    public void testFBN(){
        Stream.iterate(new int[]{0,1},t-> new int[]{t[1],t[0]+t[1]}).limit(10).map( t -> t[0]).forEach(System.out::println);
    }
}
