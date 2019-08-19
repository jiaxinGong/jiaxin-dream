package gof.observer;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/14 20:50
 */
public class FengNiaoImpl implements FengNiao {

    private static int id = 0;
    private String name;

    private FlowerSubject flowerSubject;

    public FengNiaoImpl(FlowerSubject flowerSubject) {
        this.name = "蜂鸟" + (++id);
        this.flowerSubject = flowerSubject;
    }

    @Override
    public void tellMe() {
        if (FlowerState.HuaKai.equals(flowerSubject.getFlowerState())) {
            System.out.println(getName() + "采蜜");
        } else if (FlowerState.HuaXie.equals(flowerSubject.getFlowerState())) {
            System.out.println(getName() + "回巢");
        }
    }

    public String getName() {
        return name;
    }
}
