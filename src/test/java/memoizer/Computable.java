package memoizer;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/18 9:12
 */
public interface Computable<A,V>{
    V compute(A a) throws InterruptedException;
}