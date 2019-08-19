package gof.visitor;

/**
 * <p>
 * 客户端
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/11 17:46
 */
public class Client {

    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();
        Bill bill = new IncomeBill("收入1", 1000D);
        Bill bill2 = new IncomeBill("收入2", 500D);
        Bill bill3 = new IncomeBill("收入3", 1500D);
        accountBook.addBill(bill);
        accountBook.addBill(bill2);
        accountBook.addBill(bill3);

        Bill bill4 = new ConsumerBill("支出1", 200D);
        Bill bill5 = new ConsumerBill("支出2", 500D);
        Bill bill6 = new ConsumerBill("支出3", 1000D);
        accountBook.addBill(bill4);
        accountBook.addBill(bill5);
        accountBook.addBill(bill6);

        accountBook.visit(new BossVisitor());
        accountBook.visit(new CPAVisitor());

        Object o  = new Object();
    }
}
