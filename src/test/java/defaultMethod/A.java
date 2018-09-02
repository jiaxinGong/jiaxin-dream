package defaultMethod;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/8 9:53
 */
public interface A {

    default void hello() {
        System.out.println("hello from A");
    }

    static void nihao() {
        System.out.println("你好，来自A");
    }
}
