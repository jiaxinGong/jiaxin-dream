package gof.chain;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/8 19:18
 */
public class Client {

    public static void main(String[] args) {
        CApprover cApprover = new CApprover(null);
        BApprover bApprover = new BApprover(cApprover);
        AApprover aApprover = new AApprover(bApprover);
        System.out.println("==================1================");
        System.out.println(aApprover.handleRequest(1));
        System.out.println("==================3================");
        System.out.println(aApprover.handleRequest(3));
        System.out.println("==================4================");
        System.out.println(aApprover.handleRequest(4));
        System.out.println("==================5================");
        System.out.println(aApprover.handleRequest(5));
        System.out.println("==================8================");
        System.out.println(aApprover.handleRequest(8));
        System.out.println("=================15=================");
        System.out.println(aApprover.handleRequest(15));
    }
}
