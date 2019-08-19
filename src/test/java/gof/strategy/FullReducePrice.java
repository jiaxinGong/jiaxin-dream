package gof.strategy;

import gof.strategy.annotation.OnceValidRegion;
import gof.strategy.annotation.ValidRegion;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/28 21:44
 */
@OnceValidRegion(@ValidRegion(min = 1000,order = 50))
public class FullReducePrice implements CalculatePrice {

    @Override
    public Double calculate(Double price) {
        return price - 200;
    }
}
