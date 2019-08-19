package gof.visitor;

/**
 * <p>
 * 注会
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/11 17:44
 */
public class CPAVisitor implements Visitor {

    @Override
    public void viewConsumerBill(ConsumerBill bill) {
        System.out.println("注会不关心消费" + "|" + bill.getItem() + ":" + bill.getAmount());
    }

    @Override
    public void viewIncomeBill(IncomeBill bill) {
        System.out.println(
            "注会只关心收入交税了没有" + "|" + bill.getItem() + ":" + bill.getAmount() + "|该交税：" + (0.15 * bill.getAmount()));
    }
}
