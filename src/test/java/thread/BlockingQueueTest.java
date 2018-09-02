package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/17 20:01
 */
public class BlockingQueueTest {
    BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);

    public void add(Integer val){
        try {
            blockingQueue.put(val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Integer get(){
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return blockingQueue.remove();
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.getAndAdd(1);
//        System.out.println(atomicInteger);
        atomicInteger.addAndGet(1);
        System.out.println(atomicInteger);
    }
}
