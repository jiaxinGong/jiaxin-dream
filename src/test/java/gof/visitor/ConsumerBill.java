package gof.visitor;

/**
 * <p>
 * 消费账单
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/11 17:24
 */

public class ConsumerBill implements Bill {

    private String item;

    private Double amount;

    public ConsumerBill(String item, Double amount) {
        super();
        this.item = item;
        this.amount = amount;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.viewConsumerBill(this);
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
