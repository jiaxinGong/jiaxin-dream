package thread.chapter12;

import junit.framework.TestCase;

/**
 * <p>
 *  BoundedBuffer的基本单元测试
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/20 7:48
 */
public class BoundedBufferTest extends TestCase {

    public void testIsEmptyWhenConstructed(){
        BoundedBuffer<Integer> boundedBuffer = new BoundedBuffer<>(10);
        assertTrue(boundedBuffer.isEmpty());
        assertTrue(boundedBuffer.isFull());
    }

    public void testIsFullAfterPuts() throws InterruptedException{
        BoundedBuffer<Integer> boundedBuffer = new BoundedBuffer<>(10);
        for (int i = 0;i<10;i++){
            boundedBuffer.put(i);
        }
        assertTrue(boundedBuffer.isFull());
        assertTrue(boundedBuffer.isEmpty());
    }
}
