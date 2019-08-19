package gof.singleton;

/**
 * <p>
 * 单例
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/26 15:25
 */
public class Singleton_Good {

    /**
     * 1、私有化构造器
     * 2、静态内部类
     * 3、一个类的静态属性只会在第一次加载类时初始化
     */

    private Singleton_Good() {
    }

    public static Singleton_Good getInstance() {
        return InnerClass.singleton_good;
    }

    private static class InnerClass {

        static Singleton_Good singleton_good = new Singleton_Good();
    }
}
