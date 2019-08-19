package gof.command;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 14:57
 */
public class Client {

    public static void main(String[] args) {
        Programmer programmerA = new Programmer("程序员A");
        Programmer programmerB = new Programmer("程序员B");

        ProductManage productManage = new ProductManage(programmerA,programmerB);

        SalesMan salesMan1 = new SalesMan("销售员1", productManage);
        SalesMan salesMan2 = new SalesMan("销售员2", productManage);
        SalesMan salesMan3 = new SalesMan("销售员3", productManage);
        salesMan1.hasAProblem();
        salesMan1.helpMeExportReport();
        salesMan2.hasAProblem();
        salesMan2.helpMeExportReport();
        salesMan3.hasAProblem();
        salesMan3.helpMeExportReport();

        // 第一天分发
        productManage.distributeTask(2);
        System.out.println("=======第二天分发=======");
        // 第二天分发
        productManage.distributeTask(3);
    }
}
