package defaultMethod;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/8 9:54
 */
public interface B {
    default void hello(){
        System.out.println("hello from B");
    }
}
