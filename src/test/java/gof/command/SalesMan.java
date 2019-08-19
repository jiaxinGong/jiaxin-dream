package gof.command;

/**
 * <p>
 * 业务员/销售员
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 13:58
 */
public class SalesMan {

    private String name;

    private ProductManage productManage;

    public String getName() {
        return name;
    }

    public SalesMan(String name, ProductManage productManage) {
        super();
        this.name = name;
        this.productManage = productManage;
    }

    public void hasAProblem() {
        productManage.collectTask(new SolveBugsCmd(productManage.getProgrammer()));
    }

    public void helpMeExportReport() {
        productManage.collectTask(new ExportReportCmd(productManage.getProgrammer()));
    }
}
