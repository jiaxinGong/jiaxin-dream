package defaultMethod;

/**
 * <p>
 * java 8 默认方法
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/8 9:49
 */
public class DefaultMethodTest implements B,A{

    @Override
    public void hello() {
        A.super.hello();
    }
}
