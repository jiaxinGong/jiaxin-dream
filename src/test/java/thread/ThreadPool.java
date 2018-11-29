package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(3, 3, 10L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                MyTask myTask = (MyTask) r;
                System.out.println("reject:"+myTask.name);
            }
        });

        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyTask(i + "", executorService));
        }


        executorService.shutdown();
    }

    static class MyTask implements Runnable {

        ExecutorService executorService;
        private final String name;

        public MyTask(String name, ExecutorService executorService) {
            this.name = name;
            this.executorService = executorService;
        }

        @Override
        public void run() {
            System.err.println("start:" + name);
//            try {
//                TimeUnit.SECONDS.sleep(new Random().nextInt(3));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (name.equals("1")) {
                System.out.println("异常");
//                executorService.shutdown();
//                throw new RuntimeException("异常");
                int s = 10 % 0;
            }
            System.err.println("end::" + name);
        }
    }

}
