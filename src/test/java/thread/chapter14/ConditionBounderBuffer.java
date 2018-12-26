package thread.chapter14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 使用显示条件变量的有界缓存
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/26 7:25
 */
public class ConditionBounderBuffer<T> {

    protected final Lock lock = new ReentrantLock();
    // 条件谓词： count < items.length
    private final Condition notFull = lock.newCondition();
    // 条件谓词：count > 0
    private final Condition notEmpty = lock.newCondition();

    private final int BUFFER_SIZE = 10;
    private T[] itmes = (T[]) new Object[BUFFER_SIZE];
    private int head;
    private int tail;
    private int count;

    // 阻塞直到：notFull
    public void put(T t) throws InterruptedException {
        lock.lock();
        try {
            // 满了需等待 notFull.await
            if (count == itmes.length) {
                notFull.await();
            }
            // 放入元素
            itmes[tail] = t;
            // 维护尾部位置
            if (++tail == itmes.length) {
                tail = 0;
            }
            ++count;
            // 放入元素需要唤醒 notEmpty.signal
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 阻塞直到：notEmpt
    public T get() throws InterruptedException {
        lock.lock();
        try {
            // 空需等待 notEmpty.await
            if (count == 0) {
                notEmpty.await();
            }
            // 获取元素
            T t = itmes[head];
            itmes[head] = null;
            // 维护头位置
            if (++head == itmes.length) {
                head = 0;
            }
            // 维护总数量
            --count;
            // 取出元素需唤醒 notFull.signal
            notFull.signal();
            // 返回
            return t;
        } finally {
            lock.unlock();
        }
    }
}
