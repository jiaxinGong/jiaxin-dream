package coffee;

import com.jiaxin.dream.utils.httpclient.HttpClientUtil;
import com.jiaxin.dream.utils.httpclient.common.HttpConfig;
import com.jiaxin.dream.utils.httpclient.common.HttpHeader;
import org.apache.http.Header;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2018/12/31 20:56
 */
public class APITest {
    private String urlPrefix = "http://127.0.0.1:8080/pick-coffee/api";// 本地

    Header[] headers = HttpHeader.custom()
        .other("Content-Type", "application/json")
        .build();

    @Test
    public void addStudent() throws Exception {
        String url = urlPrefix + "/student/add";

        String bodyJson = "{\n"
            + "    \"name\": \"张三\",\n"
            + "    \"learnNo\": \"2018133103\"\n"
//            + "    \"sex\": 0\n"
            + "}";
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).headers(headers).json(bodyJson));
        print(res);
    }

    private void print(Object o) {
        System.out.println("----------------");
        System.out.println(o);
        System.out.println("----------------");
    }
}
