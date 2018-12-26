package thread.chapter13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/23 22:02
 */
public class LockLearn {
    // true  公平  false 非公平 默认非公平
    Lock lock = new ReentrantLock(true);

}
