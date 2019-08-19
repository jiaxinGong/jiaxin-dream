package gof.prototype;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/11 18:46
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeA prototypeA = new PrototypeA("猪八戒");
        prototypeA.setName("孙悟空");
        System.out.println(prototypeA);
        System.out.println();
        PrototypeA prototypeA1 = prototypeA.clone();
        prototypeA.setName("唐僧");
        System.out.println(prototypeA1);

    }
}
