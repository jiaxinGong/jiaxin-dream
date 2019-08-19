package gof.chain;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/8 19:15
 */
public class CApprover extends Approver {

    public CApprover(Approver next) {
        super();
        setNextHandler(next);
    }

    @Override
    Boolean handleRequest(int leaveDays) {
        if (leaveDays >= 5 && leaveDays < 10) {
            System.out.println("C审批通过");
            return true;
        } else {
            System.out.println("C审批拒绝");
            return false;
        }
    }
}
