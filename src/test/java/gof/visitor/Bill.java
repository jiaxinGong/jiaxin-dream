package gof.visitor;

/**
 * <p>
 * 账单
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/11 17:20
 */
public interface Bill {

    void accept(Visitor visitor);
}
