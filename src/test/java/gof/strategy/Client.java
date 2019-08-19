package gof.strategy;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/29 0:07
 */
public class Client {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy(200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(800D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(2600D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
    }
}
