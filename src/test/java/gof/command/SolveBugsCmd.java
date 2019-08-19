package gof.command;

/**
 * <p>
 * 解决Bub命令
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 14:03
 */
public class SolveBugsCmd implements Command {

    private Programmer programmer;

    public SolveBugsCmd(Programmer programmer) {
        super();
        this.programmer = programmer;
    }

    @Override
    public void handleTask() {
        programmer.solveBug();
    }
}
