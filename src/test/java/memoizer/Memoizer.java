package memoizer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/18 9:12
 */
public class Memoizer<A, V> implements Computable<A, V> {

    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A a) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(a);
            if (f == null) {
                FutureTask<V> ft = new FutureTask<>(() -> c.compute(a));
                f = cache.putIfAbsent(a, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
