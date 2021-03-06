package thread.chapter14;

/**
 * <p>
 * 使用条件队列实现的有界缓存
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/26 22:57
 */
public class ConditionalQueueBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public ConditionalQueueBoundedBuffer(int capacity) {
        super(capacity);
    }

    // 条件谓词 not-full (!isFull())
    // 条件谓词 not-empty (!isEmpty())

    public synchronized V get() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        boolean wasFull = isFull();
        V v = doGet();
        notifyAll();
//        条件通知，比单次通知效率更高
//        if(wasFull){
//            notifyAll();
//        }
        return v;
    }

    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        boolean wasEmpty = isEmpty();
        doPut(v);
        notifyAll();
//        条件通知，比单词通知效率更高
//        if(wasEmpty){
//            notifyAll();
//        }
    }
}
