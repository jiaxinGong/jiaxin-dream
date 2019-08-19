package gof.proxy;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/27 15:08
 */
public class ArtistA implements Supperstar {

    @Override
    public void talentShow() {
        System.out.println("ArtistA 学猫叫");
    }
}
