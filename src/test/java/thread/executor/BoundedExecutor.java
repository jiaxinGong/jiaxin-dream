package thread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * <p>
 *  信号量控制任务的提交速率Demo
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/11 7:55
 */
public class BoundedExecutor {
    private final Executor executor;
    // 信号量 信号量的上界设置为线程池的大小+可排队任务的数量
    private final Semaphore semaphore;

    public BoundedExecutor(Executor executor,int bound){
        this.executor = executor;
        semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable runnable) throws InterruptedException{
        semaphore.acquire();
        try{
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        runnable.run();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }catch (RejectedExecutionException e){
            semaphore.release();
        }
    }
}
