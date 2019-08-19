package gof.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/14 21:05
 */
public class FlowerSubject {

    private List<FengNiao> list = new ArrayList<>();
    private FlowerState flowerState;

    public FlowerState getFlowerState() {
        return flowerState;
    }

    public void setFlowerState(FlowerState flowerState) {
        this.flowerState = flowerState;
        notifyF();
    }

    public void attach(FengNiao fengNiao) {
        list.add(fengNiao);
    }

    public void detach(FengNiao fengNiao) {
        list.remove(fengNiao);
    }

    public void notifyF() {
        System.out.println(flowerState.getMsg());
        list.stream().forEach(f -> f.tellMe());
    }

}
