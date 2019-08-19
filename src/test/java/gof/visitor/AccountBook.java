package gof.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 账本
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/11 17:31
 */
public class AccountBook {

    private List<Bill> bills = new ArrayList<>();

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public void visit(Visitor visitor) {
        bills.forEach(bill -> {
            bill.accept(visitor);
        });
    }
}
