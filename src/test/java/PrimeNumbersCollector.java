import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * 质数收集器
 */
public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    /**
     * 结果容器
     *
     * @return
     */
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
    }

    /**
     * 将新的元素添加到结果容器
     *
     * @return
     */
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(isPrime(acc.get(true), candidate)).add(candidate);
        };
    }

    private boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWile(primes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
    }

    private <A> List<A> takeWile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A a : list) {
            if (!p.test(a)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }

    /**
     * 对结果容器应用最终转换
     *
     * @return
     */
    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    /**
     * 合并两个结果容器
     *
     * @return
     */
    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> map1,Map<Boolean, List<Integer>> map2) ->{
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    /**
     * 定义了收集器的行为
     *
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
}
