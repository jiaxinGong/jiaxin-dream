package concurrent.semaphore;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * <p>
 *  信号量demo 一般用于实现资源池，例如数据库连接池
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/11/12 22:06
 */
public class BoundedHashSet<T> {

    private final Set<T> set;
    private final Semaphore semaphore;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        semaphore = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        semaphore.acquire();
        boolean result = false;
        try {
            result = set.add(o);
            return result;
        } finally {
            if (!result) {
                semaphore.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean result = false;
        result = set.remove(o);
        if (result) {
            semaphore.release();
        }
        return result;
    }

}
