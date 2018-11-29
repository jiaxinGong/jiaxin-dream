import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
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

        Executor executor = new ThreadPoolExecutor(1,2,1L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),
            new DiscardPolicy());

        CompletionService completionService = new ExecutorCompletionService(executor,new ArrayBlockingQueue<>(10));

        completionService.take();
    }


    @org.junit.Test
    public void test(){
        List list = new ArrayList();
        List synchronizedList =  Collections.synchronizedList(list);
        synchronizedList.add(null);

    }

    @org.junit.Test
    private void testSyn(){
        Collections.synchronizedList(new ArrayList<>());
    }
}
