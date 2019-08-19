package gof.builder;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 22:54
 */
public class Client {

    public static void main(String[] args) {
        IBuild buildA = new BuildA();
        Director director = new Director();
        Product productA = director.getProduct(buildA);
        productA.show();

        IBuild buildB = new BuildB();
        Product productB = director.getProduct(buildB);
        productB.show();
    }
}
