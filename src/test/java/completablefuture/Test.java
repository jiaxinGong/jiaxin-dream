package completablefuture;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/8 21:17
 */
public class Test {
    public static Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try{
                delay();
                System.out.println("我计算完成了");
                completableFuture.complete(new Random(1).nextDouble());
            }catch (Exception e){
                completableFuture.completeExceptionally(e);
            }
        }).start();
        System.out.println("我已经返回了");
        return completableFuture;
    }

    public static Future<Double> getPriceAsync2(String product){
        return CompletableFuture.supplyAsync(() -> {
            delay();
            System.out.println("我计算完成了2");
            return new Random(1).nextDouble();
        });
    }
    public static void delay(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Future<Double>  future = getPriceAsync("");
        try {
            Double d = future.get();
            System.out.println("d:"+d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Future<Double>  future2 = getPriceAsync2("");
        try {
            future2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testThreadPool(){
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,8,10,TimeUnit.SECONDS,blockingQueue);
    }
}
