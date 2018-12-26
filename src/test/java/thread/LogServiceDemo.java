package thread;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>
 * 可以可靠取消的日志服务
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/6 21:52
 */
public class LogServiceDemo {

    final int CAPACITY = 1000;
    // 日志队列
    private BlockingQueue<String> queue;
    // 日志输出流
    private PrintWriter printWriter;
    // 取消标志
    private boolean cancelFlag = false;
    // 库存
    private int reservations;
    // 消费者线程
    private Thread consumerThread;

    public LogServiceDemo(PrintWriter printWriter) {
        this.queue = new LinkedBlockingQueue<>(CAPACITY);
        this.printWriter = printWriter;
        consumerThread = new LoggerThread();
    }

    public void stop() {
        synchronized (this) {
            cancelFlag = true;
        }
        // 让阻塞的线程响应中断
        consumerThread.interrupt();
    }

    public void start() {
        consumerThread.start();
    }

    private void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (cancelFlag) {
                throw new RuntimeException("已停止服务");
            }
            ++reservations;
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    try {
                        synchronized (LogServiceDemo.class) {
                            // 取消条件 用户请求取消，同时队列里无日志消息
                            if (cancelFlag && reservations == 0) {
                                break;
                            }
                        }
                        String msg = queue.take();
                        synchronized (LogServiceDemo.class) {
                            --reservations;
                        }
                        printWriter.print(msg);
                    } catch (InterruptedException e) {
                        // retry
                    }
                }
            } finally {
                printWriter.close();
            }
        }
    }
}
