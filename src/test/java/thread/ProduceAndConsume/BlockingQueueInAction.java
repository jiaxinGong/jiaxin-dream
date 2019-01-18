package thread.ProduceAndConsume;

import java.util.Date;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * <p>
 * 通过阻塞队列实现生产着消费着
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/17 8:03
 */
public class BlockingQueueInAction {

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 5L, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(100));

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(15);

        // 10生产着
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Produce("生产者name" + i, queue));
        }
        // 10个消费者
        for (int i = 10; i < 20; i++) {
            threadPoolExecutor.execute(new Consumer("消费者name" + i, queue));
        }
    }

}

class Consumer implements Runnable {

    private String name;
    BlockingQueue queue;

    public Consumer(String name, BlockingQueue queue) {
        this.name = name;
        this.queue = queue;
    }


    // 消费
    public void consumer(String name) {
        Object result = null;
        while (true) {
            try {
                result = queue.take();
                System.err
                    .println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:sss") + name + "消费了一个：" + result);
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void run() {
        consumer(name);
    }
}

class Produce implements Runnable {

    private String name;
    BlockingQueue queue;

    public Produce(String name, BlockingQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    // 生产
    public void produce(String name) {
        Random random = new Random();

        while (true) {
            try {
                int o = random.nextInt(100000);
                System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:sss") + name + "生产了一个：" + o);
                queue.put(o);

                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }


    @Override
    public void run() {
        produce(name);
    }
}