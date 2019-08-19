package gof.visitor;

/**
 * <p>
 *  Boss访问
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/11 17:41
 */
public class BossVisitor implements Visitor {

    @Override
    public void viewConsumerBill(ConsumerBill bill) {
        System.out.println("老板心好痛" + "|" + bill.getItem() + ":" + bill.getAmount());
    }

    @Override
    public void viewIncomeBill(IncomeBill bill) {
        System.out.println("老板好高兴" + "|" + bill.getItem() + ":" + bill.getAmount());
    }
}
