package foxconnTest;

import com.jiaxin.dream.utils.httpclient.HttpClientUtil;
import com.jiaxin.dream.utils.httpclient.common.HttpConfig;
import com.jiaxin.dream.utils.httpclient.common.HttpHeader;
import org.apache.http.Header;
import org.junit.Test;

public class ApplicationsControllerTest {

    private String urlPrefix = "http://127.0.0.1:8080/foxconn-approval-center/api/v1";// 本地
    private String fatUrlPrefix = "https://japi-fat.wolaidai.com/foxconn-approval-center/api/v1";// fat

    Header[] headers = HttpHeader.custom()
        .other("Content-Type", "application/json")
        .other("X-User-Mobile", "18026986473")
        .other("X-Access-Token", "e582d2612ba14601a71250735e5bdb31")
        .build();

    @Test
    public void hangUp() throws Exception {
        String url = fatUrlPrefix + "/hangUp";

        String bodyJson = "{\n"
            + "    \"pushAdminId\": 21,\n"
            + "    \"applicationIdList\": [\n"
//            + "        \"235\",\n"
            + "        \"T2018101500000011\"\n"
            + "    ]\n"
            + "}";
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(bodyJson).headers(headers));
        print(res);
    }

    @Test
    public  void distributeLoans() throws Exception{
        String url = fatUrlPrefix + "/distributeLoans";
        String bodyJson = "{\n"
            + "    \"pushAdminId\": 23,\n"
            + "    \"applicationIdList\": [\n"
            + "        \"T2018100300000010\"\n"
            + "    ],\n"
            + "    \"adminId\": \"21\"\n"
            + "}";
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(bodyJson).headers(headers));
        print(res);
    }

    private void print(Object o) {
        System.out.println("----------------");
        System.out.println(o);
        System.out.println("----------------");
    }
}
