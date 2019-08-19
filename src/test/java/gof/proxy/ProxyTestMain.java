package gof.proxy;

import java.lang.reflect.Proxy;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/27 15:18
 */
public class ProxyTestMain {

    public static void main(String[] args) {
        ArtistA artistA = new ArtistA();
        SupperstarProxyHandler supperstarProxyHandler = new SupperstarProxyHandler(artistA);
        Supperstar supperstar = (Supperstar) Proxy
            .newProxyInstance(ProxyTestMain.class.getClassLoader(), new Class[]{Supperstar.class},
                supperstarProxyHandler);
        supperstar.talentShow();
    }
}
