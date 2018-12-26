package thread.chapter14;

/**
 * <p>
 * 有界缓存实现的基类
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/26 21:53
 */
public class BaseBoundedBuffer<V> {

    private final V[] buf;
    private int head;
    private int tail;
    private int count;

    public BaseBoundedBuffer(int capacity) {
        buf = (V[]) new Object[capacity];
    }

    protected synchronized final void doPut(V v) throws InterruptedException {
        // 放入数据
        buf[tail] = v;
        // 维护尾部指针
        if (++tail == buf.length) {
            tail = 0;
        }
        // 维护总量
        ++count;
    }

    protected synchronized final V doGet() throws InterruptedException {
        // 取出数据
        V v = buf[head];
        // 维护头部指针
        if (++head == buf.length) {
            head = 0;
        }
        // 维护总量
        --count;
        // 返回
        return v;
    }

    public synchronized final boolean isFull() {
        return count == buf.length;
    }

    public synchronized final boolean isEmpty() {
        return count == 0;
    }
}
