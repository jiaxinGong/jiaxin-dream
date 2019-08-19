package gof.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * 产品经理
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/30 13:58
 */
public class ProductManage {

    private List<Programmer> programmers;

    private Stack<Command> tasks;

    private int currentIndex;

    public ProductManage(Programmer... programmers) {
        super();
        tasks = new Stack<>();
        this.programmers = Arrays.asList(programmers);
    }

    /**
     * 收集任务
     */
    void collectTask(Command cmd) {
        if(cmd != null){}
        tasks.push(cmd);
    }

    /**
     * 分发任务
     */
    void distributeTask(int num) {
        for (int i = 0; i < num && !tasks.isEmpty(); i++) {
            tasks.pop().handleTask();
        }
    }

    /**
     * 程序员获取
     */
    public Programmer getProgrammer() {
        return programmers.get(currentIndex == programmers.size() ? 0 : currentIndex++);
    }
}
