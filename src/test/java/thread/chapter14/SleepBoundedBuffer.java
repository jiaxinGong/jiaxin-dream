package thread.chapter14;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 使用简单阻塞实现的有界缓存
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/26 22:35
 */
public class SleepBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public SleepBoundedBuffer(int capacity) {
        super(capacity);
    }

    // put
    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                // 满了需等待
                if (!isFull()) {
                    // 放入元素
                    doPut(v);
                    return;
                }
            }
            TimeUnit.MILLISECONDS.sleep(100L);
        }
    }

    // get
    public V get() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // 空了需要等待
                if (!isEmpty()) {
                    // 获取并返回
                    V v = doGet();
                    return v;
                }
            }
            TimeUnit.MILLISECONDS.sleep(100L);
        }

    }
}
