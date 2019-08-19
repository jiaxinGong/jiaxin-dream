package gof.builder;

/**
 * <p>
 * 具体建造者B
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 22:34
 */
public class BuildB implements IBuild {

    @Override
    public void buildPart1(Product product) {
        product.addPart("B第一部分已建造好");
    }

    @Override
    public void buildPart2(Product product) {
        product.addPart("B第二部分已建造好");
    }
}
