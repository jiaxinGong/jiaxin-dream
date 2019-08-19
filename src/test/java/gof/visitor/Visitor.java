package gof.visitor;

/**
 * <p>
 * 访问者
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/11 17:22
 */
public interface Visitor {

    void viewConsumerBill(ConsumerBill bill);

    void viewIncomeBill(IncomeBill bill);
}
