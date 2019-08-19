package gof.command;

/**
 * <p>
 * 报表导出命令
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 14:01
 */
public class ExportReportCmd implements Command {

    private Programmer programmer;

    public ExportReportCmd(Programmer programmer) {
        super();
        this.programmer = programmer;
    }


    @Override
    public void handleTask() {
        programmer.exportReport();
    }
}
