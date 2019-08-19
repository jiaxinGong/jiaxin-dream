package gof.chain;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/8 19:12
 */
public class BApprover extends Approver {

    public BApprover(Approver next) {
        super();
        setNextHandler(next);
    }

    @Override
    Boolean handleRequest(int leaveDays) {
        if (leaveDays < 5) {
            if(leaveDays == 3){
                System.out.println("B审批拒绝");
                return false;
            }
            System.out.println("B 审批通过");
            return true;
        }
        if (getNextHandler() != null) {
            return getNextHandler().handleRequest(leaveDays);
        }
        return null;
    }
}
