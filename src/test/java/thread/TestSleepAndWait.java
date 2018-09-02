package thread;

import java.util.concurrent.Executors;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/17 10:42
 */
public class TestSleepAndWait {

    public static void main(String[] args) {
        Object o = new Object();
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t = new Thread(() -> System.out.println("s"));
        t.start();
        t.run();

    }
}
