package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class Volatile {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        count.addAndGet(1);

        LongAdder longAdder = new LongAdder();
        longAdder.increment();
    }
}
