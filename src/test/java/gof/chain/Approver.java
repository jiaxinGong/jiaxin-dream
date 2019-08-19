package gof.chain;

/**
 * <p>
 * 审批者接口
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/8/8 18:49
 */
public abstract class Approver {

    private Approver nextHandler;

    public void setNextHandler(Approver nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Approver getNextHandler() {
        return nextHandler;
    }

    abstract Boolean handleRequest(int leaveDays);
}
