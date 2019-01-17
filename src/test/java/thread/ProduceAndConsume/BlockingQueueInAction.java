package thread.ProduceAndConsume;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>
 * 通过阻塞队列实现生产着消费着
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/17 8:03
 */
public class BlockingQueueInAction {

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(10);
        // 10生产着
        // 10个消费者
    }

}

class Consumer {

    BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    // 消费
    public Object consumer() {
        Object result = null;
        try {
            result = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}

class Produce {

    BlockingQueue queue;

    public Produce(BlockingQueue queue) {
        this.queue = queue;
    }

    // 消费
    public void produce(Object o) {
        queue.add(o);
    }
}