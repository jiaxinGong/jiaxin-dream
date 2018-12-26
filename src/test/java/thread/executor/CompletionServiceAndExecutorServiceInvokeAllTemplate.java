package thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * CompletionService = Executor + Blocking ; ExecutorService InvokeAll
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/11/24 10:17
 */
public class CompletionServiceAndExecutorServiceInvokeAllTemplate {

    static ExecutorService executorService = new ThreadPoolExecutor(4, 6, 10L, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(10), new DiscardPolicy());

    // 5s内报价，为报出价取消任务
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                invokeAllQuote("invokeAllQuote-超过时限任务会取消");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                completionQuote("completionQuote-所有任务都会执行,先完成先返回");
            }
        }).start();
    }

    static void completionQuote(String flag) {
        CompletionService<TravelQuote> completionService = new ExecutorCompletionService<>(executorService);
        completionService.submit(new QuoteTask(flag + "-江西"));
        completionService.submit(new QuoteTask(flag + "-湖南"));
        completionService.submit(new QuoteTask(flag + "-深圳"));

        long endTime = System.nanoTime() + 5_000_000_000L;
        List<TravelQuote> travelQuotes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            try {
//                completionService.take();
                Future<TravelQuote> future = completionService.poll(endTime - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (future != null) {
                    travelQuotes.add(future.get());
//                    System.out.println(future.get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("=======completionQuote报价结束=======》" + travelQuotes);
    }

    static void invokeAllQuote(String flag) {
        List<QuoteTask> tasks = new ArrayList<>();
        tasks.add(new QuoteTask(flag + "-江西"));
        tasks.add(new QuoteTask(flag + "-湖南"));
        tasks.add(new QuoteTask(flag + "-深圳"));
        List<TravelQuote> travelQuotes = new ArrayList<>();
        try {
            Long start = System.nanoTime();
            System.out.println("----invokeAll-start-" + start);
               List<Future<TravelQuote>> futures = executorService.invokeAll(tasks, 5L, TimeUnit.SECONDS);
            Long end = System.nanoTime();
            System.out.println("----invokeAll-end-" + end + "，历时：" + (end - start) / 1000_000_000L + "s");
            for (Future<TravelQuote> future : futures) {
                try {
                    if (!future.isCancelled()) {
                        TravelQuote travelQuote = future.get();
                        travelQuotes.add(travelQuote);
                    }
                } catch (CancellationException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("=======invokeAllQuote报价结束=======》" + travelQuotes);
    }
}

class QuoteTask implements Callable<TravelQuote> {

    private String channelName;

    public QuoteTask(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public TravelQuote call() throws Exception {
        int quoteTime = new Random().nextInt(10);
        System.out.println("[" + channelName + "]将要耗时:" + quoteTime + "s");
        TimeUnit.SECONDS.sleep(quoteTime);
        System.out.println("[" + channelName + "]已报完价");
        return new TravelQuote(channelName, new Random().nextInt(100), quoteTime);
    }
}

class TravelQuote {

    public TravelQuote(String channelName, int price, int quoteTime) {
        this.channelName = channelName;
        this.price = price;
        this.quoteTime = quoteTime;
    }

    // 渠道名称
    private String channelName;
    // 单价
    private int price;
    // 耗时s
    private int quoteTime;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuoteTime() {
        return quoteTime;
    }

    public void setQuoteTime(int quoteTime) {
        this.quoteTime = quoteTime;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TravelQuote{" +
            "channelName='" + channelName + '\'' +
            ", price=" + price +
            ", quoteTime=" + quoteTime +
            '}';
    }
}