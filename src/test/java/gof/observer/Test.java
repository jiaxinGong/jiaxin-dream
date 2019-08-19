package gof.observer;

import java.util.Observer;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/14 21:34
 */
public class Test {

    public static void main(String[] args) {
        FlowerSubject flowerSubject = new FlowerSubject();
        FengNiao fengNiao1 = new FengNiaoImpl(flowerSubject);
        FengNiao fengNiao2 = new FengNiaoImpl(flowerSubject);
        FengNiao fengNiao3 = new FengNiaoImpl(flowerSubject);
        flowerSubject.attach(fengNiao1);
        flowerSubject.attach(fengNiao2);
        flowerSubject.attach(fengNiao3);

        flowerSubject.setFlowerState(FlowerState.HuaKai);
        flowerSubject.setFlowerState(FlowerState.HuaXie);
    }

}
