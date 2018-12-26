package thread.executor;

/**
 * <p>
 * finally  在返回之前一定会执行，如果有异常，就在抛出异常之前执行
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/11/28 22:26
 */
public class TryFinallyOrTryCatchFinally {

    public static void main(String[] args) {
        tryCatchFinally();
        tryFinally();
        Thread thread;
    }

    static void tryFinally() {
        try {
            System.out.println("tryFinally start");
            int i = 10 / 0;
            System.out.println("tryFinally 0000");
        } finally {
            System.out.println(" tryFinally fianlly");
        }
    }

    static void tryCatchFinally(){
        try{
            System.out.println("tryCatchFinally start");
            int i = 10 / 0;
            System.out.println("tryCatchFinally 0000");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(" tryCatchFinally fianlly");
        }
    }

}
