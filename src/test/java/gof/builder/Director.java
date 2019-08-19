package gof.builder;

/**
 * <p>
 * 指挥者
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 22:39
 */
public class Director {

    public Product getProduct(IBuild build) {
        Product product = new Product();
        build.buildPart1(product);
        build.buildPart2(product);
        return product;
    }
}
