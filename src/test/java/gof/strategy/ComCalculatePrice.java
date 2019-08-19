package gof.strategy;

import gof.strategy.annotation.TotalValidRegion;
import gof.strategy.annotation.ValidRegion;

/**
 * <p>
 * 普通计价
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/28 20:18
 */
@TotalValidRegion(@ValidRegion(max = 1000,order = 99))
public class ComCalculatePrice implements CalculatePrice {

    @Override
    public Double calculate(Double price) {
        return price;
    }
}
