package httpClient;

import com.alibaba.fastjson.JSON;
import com.jiaxin.dream.utils.httpclient.HttpClientUtil;
import com.jiaxin.dream.utils.httpclient.common.HttpConfig;
import com.jiaxin.dream.utils.httpclient.common.HttpHeader;
import com.jiaxin.dream.utils.httpclient.exception.HttpProcessException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author jiaxin.gong
 * @since 2019/1/16 9:27
 */
public class ThorOperationAppTest {

    //    private String urlPrefix = "http://127.0.0.1:8082/thor/api/v1";
    private String urlPrefix = "https://japi-fat.wolaidai.com/thor-operation/api/v1";
//private String urlPrefix = "http://127.0.0.1:8082/thor/api/v1";

    Header[] headers = HttpHeader.custom()
        .other("Content-Type", "application/json")
        .other("X-User-Mobile", "18026986473")
//        .other("x-user-token", "").build();
        .other("x-user-token", "gmjhzoslbvbsq0292340377812205568").build();

    @Test
    public void listApp() throws HttpProcessException {
        String url = urlPrefix + "/app/list";
        Map<Object, Object> param = new HashMap<>();
        PageParam pageParam = new PageParam();
        pageParam.setPageNo(1);
        pageParam.setPageSize(100);
        param.put("pageParam", pageParam);

        String paramJsonStr = JSON.toJSONString(param);
        System.out.println("-------->paramJsonStr:" + paramJsonStr);
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(paramJsonStr).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void save() throws HttpProcessException {
        String url = urlPrefix + "/app/add";
        Map<Object, Object> param = new HashMap<>();
        param.put("code", "nb");
        param.put("name", "nb2");
        param.put("district", "620000");
        String paramJsonStr = JSON.toJSONString(param);
        System.out.println("-------->paramJsonStr:" + paramJsonStr);
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(paramJsonStr).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void find() throws HttpProcessException {
        String url = urlPrefix + "/app/find/1";

        String res = HttpClientUtil
            .get(HttpConfig.custom().url(url).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void update() throws HttpProcessException {
        String url = urlPrefix + "/app/update";
        Map<Object, Object> param = new HashMap<>();
        param.put("id", "8");
        param.put("code", "nb");
        param.put("state", false);
        String paramJsonStr = JSON.toJSONString(param);
        System.out.println("-------->paramJsonStr:" + paramJsonStr);
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(paramJsonStr).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }
}
