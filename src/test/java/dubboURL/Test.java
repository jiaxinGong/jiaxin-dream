package dubboURL;

import com.alibaba.dubbo.common.URL;
import com.alibaba.fastjson.JSON;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/7/25 14:59
 */
public class Test {
    @org.junit.Test
    public void t(){
//       String url = "https://git.wolaidai.com/WelabCo/TB/Thor/thor-operation/commit/2f5aa092968ca5b5b990a11403b4a31961acc5e6";
        String url = "http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11000002000001";
        URL newUrl  = URL.valueOf(url);
        System.out.println(JSON.toJSONString(newUrl));
    }
}
