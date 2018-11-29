package com.jiaxin.dream.cache;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        return new BigInteger(arg);
    }
}
