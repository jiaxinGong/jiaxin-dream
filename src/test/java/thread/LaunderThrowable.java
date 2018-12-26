package thread;

/**
 * <p>
 *  自定义异常
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/12/5 21:56
 */
public class LaunderThrowable extends RuntimeException {

    public LaunderThrowable() {
    }

    public LaunderThrowable(Throwable t) {
        super(t);
    }
}
