package gof.singleton;

/**
 * <p>
 * 单例
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/26 15:11
 */
public class Singleton {

    /**
     * 1、构造器私有化
     * 2、为空再创建，考虑并发，需同步
     * 3、此方法有缺陷，因为JVM创建对象不是原子性的，
     *   分为3个步骤：
     *      1、分配内存
     *      2、初始化构造器
     *      3、将对象指向分配的内存地址
     *    如果JVM创建对象按以上顺序是没有问题的，但如果发生重排序（2和3互换），
     *    则就会出现问题（有可能获取到还未初始化的对象）
     */

    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
