package gof.visitor;

/**
 * <p>
 * 收入账单
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/11 17:27
 */
public class IncomeBill implements Bill {

    private String item;

    private Double amount;

    public IncomeBill(String item, Double amount) {
        this.item = item;
        this.amount = amount;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.viewIncomeBill(this);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
