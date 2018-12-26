package thread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 未捕获的异常处理,execute才生效，submit不生效
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/8 20:09
 */
public class UncaughtExceptionHandlerDemo {

    static class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("name:" + t.getName() + ",message:" + e.getMessage());
        }
    }

    static ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            return thread;
        }
    };

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2,
            2,
            1L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            threadFactory,
            new DiscardPolicy());

//        executorService.submit(new Runnable() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("name:" + Thread.currentThread().getName());
                int i = 10 / 0;
                System.out.println("EXIT1");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("name:" + Thread.currentThread().getName());
                System.out.println("EXIT2");
            }
        });

        executorService.shutdown();
    }
}
