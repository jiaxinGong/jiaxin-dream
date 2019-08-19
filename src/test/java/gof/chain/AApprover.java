package gof.chain;

import sun.security.krb5.internal.APRep;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/8 19:09
 */
public class AApprover extends Approver {

    public AApprover(Approver next) {
        super();
        setNextHandler(next);
    }

    @Override
    Boolean handleRequest(int leaveDays) {
        if (leaveDays < 3) {
            System.out.println("A审批通过");
            return true;
        }
        if (getNextHandler() != null) {
            return getNextHandler().handleRequest(leaveDays);
        }
        return null;
    }
}
