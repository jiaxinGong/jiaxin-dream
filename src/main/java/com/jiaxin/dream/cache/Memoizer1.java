package com.jiaxin.dream.cache;

import java.util.HashMap;
import java.util.Map;

public class Memoizer1<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new HashMap<>();
    private Computable<A, V> computable;

    public Memoizer1(Computable computable) {
        this.computable = computable;
    }

    /**
     * HashMap并不是线程安全，采取保守方法，同步整个compute方法
     * @param arg
     * @return
     * @throws InterruptedException
     */
    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = computable.compute(arg);
            cache.put(arg, (V) result);
        }
        return result;
    }
}
