package thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 在专门的线程中中断任务
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/5 21:47
 */
public class InteruptDemo {

    public static void timeRun(final Runnable r, long timeOut, TimeUnit timeUnit) throws InterruptedException {

        class RethrowableTask implements Runnable {

            private volatile Throwable t;

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Exception e) {
                    t = e;
                }
            }

            void rethrow() {
                if (t != null) {
                    throw new LaunderThrowable(t);
                }
            }
        }

        RethrowableTask rethrowableTask = new RethrowableTask();
        final Thread taskThreak = new Thread(rethrowableTask);
        taskThreak.start();

        ScheduledThreadPoolExecutor cancelExec = new ScheduledThreadPoolExecutor(2);
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThreak.interrupt();
            }
        }, timeOut, timeUnit);

        taskThreak.join(timeUnit.toMillis(timeOut));

        rethrowableTask.rethrow();

    }
}