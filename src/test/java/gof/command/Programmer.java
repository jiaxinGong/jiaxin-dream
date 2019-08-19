package gof.command;

/**
 * <p>
 * 程序员
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 13:59
 */
public class Programmer {

    private String name;

    public Programmer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 解决bug
     */
    public void solveBug() {
        System.out.println("开始解决bug");
        System.out.println("bug解决中....");
        System.out.println("bug解决完毕");
    }

    /**
     * 导出报表
     */
    public void exportReport() {
        System.out.println("开始导出报表");
        System.out.println("导出报表解决中....");
        System.out.println("导出报表完毕");
    }
}
