package thread.chapter12;

    import java.util.concurrent.CyclicBarrier;
    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.LinkedBlockingQueue;
    import java.util.concurrent.ThreadPoolExecutor;
    import java.util.concurrent.TimeUnit;
    import java.util.concurrent.atomic.AtomicInteger;
    import junit.framework.TestCase;

/**
 * <p>
 * 测试BoundedBuffer的生产着-消费者程序
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/20 20:51
 */
public class PutTakeTest extends TestCase {

    private static final ExecutorService pool = new ThreadPoolExecutor(20, 20, 1L, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(100));
    private final AtomicInteger putSum = new AtomicInteger(0);
    private final AtomicInteger takeSum = new AtomicInteger(0);
    private final CyclicBarrier barrier;
    private final BoundedBuffer<Integer> boundedBuffer;
    private final int nTrials;
    private final int nPairs;

    public static void main(String[] args) {
        new PutTakeTest(10,10,100_000).test();
        pool.shutdown();
    }

    public PutTakeTest(int capacity, int nPairs, int nTrials) {
        boundedBuffer = new BoundedBuffer<>(capacity);
        this.nPairs = nPairs;
        this.nTrials = nTrials;
        barrier = new CyclicBarrier(2 * nPairs + 1);
    }

    void test() {
        try {
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            barrier.await();// 等待所有线程就绪
            barrier.await();// 等待所有线程完成
            System.out.println("putSum.get()="+putSum.get());
            System.out.println("takeSum.get()="+takeSum.get());
            assertEquals(putSum.get(), takeSum.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            try {
                int seed = this.hashCode() ^ (int) System.nanoTime();
                int sum = 0;
                barrier.await();
                for (int i = 0; i < nTrials; i++) {
                    boundedBuffer.put(seed);
                    sum += seed;
                    seed = xorShift(seed);
                }
                putSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                barrier.await();
                int sum = 0;
                for (int i = 0; i < nTrials; i++) {
                    sum += boundedBuffer.take();
                }
                takeSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }

}