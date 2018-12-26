package thread.chapter14;

/**
 * <p>
 * 使用条件队列实现的有界缓存
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/26 22:57
 */
public class IfQueueBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public IfQueueBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized V get() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        boolean wasFull = isFull();
        V v = doGet();
        notifyAll();
//        条件通知，比单词通知效率更高
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
