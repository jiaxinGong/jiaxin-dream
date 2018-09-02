import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/18 9:59
 */
public class Test {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        int a = 128;
        System.out.println((byte)a);
        int b = 129;
        System.out.println((byte)b);
        int c = 255;
        System.out.println((byte)c);
        int d = 256;
        System.out.println((byte)d);
        int e = 257;
        System.out.println((byte)e);
        StringBuffer sb = new StringBuffer();
        sb.append("");

        double hh = 0.00001;
    }
}
