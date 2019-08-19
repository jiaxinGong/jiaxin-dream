package gof.builder;

/**
 * <p>
 * 建造者接口
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 22:32
 */
public interface IBuild {

    void buildPart1(Product product);

    void buildPart2(Product product);
}
