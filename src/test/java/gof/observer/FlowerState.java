package gof.observer;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/27 17:56
 */
public enum FlowerState {
    HuaKai("花开"), HuaXie("花谢");
    private String msg;

    FlowerState(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
