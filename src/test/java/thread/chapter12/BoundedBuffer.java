package thread.chapter12;

import java.util.concurrent.Semaphore;

/**
 * <p>
 * 基于信号量自定义的有界队列/缓存
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/20 7:21
 */
public class BoundedBuffer<E> {

    private final Semaphore availableItems;
    private final Semaphore availableSpaces;

    private final E[] items;
    private int putPosition = 0;
    private int takePosition = 0;

    public BoundedBuffer(int capacity) {
        availableItems = new Semaphore(0);
        availableSpaces = new Semaphore(capacity);
        items = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        Integer a = availableItems.availablePermits();
        return a == 0;
    }

    public boolean isFull() {
        Integer a = availableSpaces.availablePermits();
        return a == 0;
    }

    public void put(E e) throws InterruptedException {
        availableSpaces.acquire();
        doInsert(e);
        availableItems.release();// 增加一个许可
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E x = doExtract();
        availableSpaces.release();
        return x;
    }

    private synchronized void doInsert(E e) throws InterruptedException {
        int i = putPosition;
        items[i] = e;
        putPosition = ++i == items.length ? 0 : i;
    }

    private synchronized E doExtract() throws InterruptedException {
        int i = takePosition;
        E x = items[i];
        items[i] = null;
        takePosition = ++i == items.length ? 0 : i;
        return x;
    }
}
