package gof.strategy;

import gof.strategy.annotation.TotalValidRegion;
import gof.strategy.annotation.ValidRegion;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/28 20:21
 */
@TotalValidRegion(@ValidRegion(min = 3000,order = 99))
public class SupperVipCaculatePrice implements CalculatePrice {

    @Override
    public Double calculate(Double price) {
        return price * 0.75;
    }
}
