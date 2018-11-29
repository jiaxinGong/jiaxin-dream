package com.jiaxin.dream.cache;

public interface Computable<A, V> {

    V compute(A arg) throws InterruptedException;
}
