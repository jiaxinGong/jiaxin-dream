package httpClient;

import com.alibaba.fastjson.JSON;
import com.jiaxin.dream.utils.httpclient.HttpClientUtil;
import com.jiaxin.dream.utils.httpclient.common.HttpConfig;
import com.jiaxin.dream.utils.httpclient.common.HttpHeader;
import com.jiaxin.dream.utils.httpclient.exception.HttpProcessException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.junit.Test;

public class PlatformsTest {

    private String urlPrefix = "http://127.0.0.1:8082/thor/api/v1";
//    private String urlPrefix = "http://japi-dev.wolaidai.com/thor-operation/api/v1";

    Header[] headers = HttpHeader.custom()
        .other("Content-Type", "application/json")
        .other("X-User-Mobile", "18026986473")
        .other("X-Access-Token", "").build();

    @Test
    public void listPlatforms() throws HttpProcessException {
        String url = urlPrefix + "/platform/list";
        Map<Object, Object> param = new HashMap<>();
//        param.put("productCode", "1");
//        param.put("partnerId", 1);
//        param.put("productName", "安信小贷-薪金贷");
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
        System.out.println("===z======================res=========================");
    }

    @Test
    public void findByProductCode() throws HttpProcessException {
        String url = urlPrefix + "/platform/findByProductCode/AX-XJD";

        String res = HttpClientUtil
            .get(HttpConfig.custom().url(url));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void findWithAuthConfigByProductCode() throws HttpProcessException {
//        String url = urlPrefix + "/platform/findWithAuthConfigByProductCode/BM-KYD";
        String url = urlPrefix + "/platform/findWithAuthConfigByProductCode/CQBM-KYD";

        String res = HttpClientUtil
            .get(HttpConfig.custom().url(url).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void findMetaData() throws HttpProcessException {
        String url = urlPrefix + "/authConfig/listMetaData";
        Header[] headers = HttpHeader.custom()
            .other("Content-Type", "application/json")
            .other("X-User-Token", "07e3fa95b61122b406afa007832a41a2").build();
        String res = HttpClientUtil
            .get(HttpConfig.custom().url(url).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void addOrUpdate() throws HttpProcessException {
        String jsonStr = "{\n"
            + "  \"applyCondition\": \"[sdfsdfs;,sdfdsfds;,sdfsdfsdff ]\",\n"
            + "  \"applyFlow\": \"sdfsdfsdfsdf\",\n"
            + "  \"authConfigList\": [\n"
            + "    {\n"
            + "      \"id\": 552,\n"
            + "      \"description\": \"sdfsdfs\",\n"
            + "      \"items\": \"zmScoreAuth,   mobileAuth,   houseFundAuth\",\n"
            + "      \"name\": \"必填项1\",\n"
            + "      \"required\": 3,\n"
            + "      \"sort\": 1\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\": 553,\n"
            + "      \"description\": \"AAAA\",\n"
            + "      \"items\": \"houseFundAuth,   shebaoAuth,   zmScoreAuth\",\n"
            + "      \"sort\": 2,\n"
            + "      \"name\": \"3选3\",\n"
            + "      \"required\": \"2\"\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\":554,\n"
            + "      \"description\": \"BBBB\",\n"
            + "      \"items\": \"zmScoreAuth,   shebaoAuth,   houseFundAuth\",\n"
            + "      \"name\": \"选填项\",\n"
            + "      \"required\": 0,\n"
            + "      \"sort\": 3\n"
            + "    }\n"
            + "  ],\n"
            + "  \"authFlag\": true,\n"
            + "  \"city\": \"110100,110000\",\n"
            + "  \"information\": \"sf少的发水电费水电费说\",\n"
            + "  \"interest\": 10,\n"
            + "  \"isHot\": false,\n"
            + "  \"isSendEmail\": false,\n"
            + "  \"isSendSms\": false,\n"
            + "  \"isWedefend\": true,\n"
            + "  \"isformation\": \"\",\n"
            + "  \"maxAge\": \"50\",\n"
            + "  \"maxAmount\": \"40\",\n"
            + "  \"maxInterest\": 30,\n"
            + "  \"minAge\": \"18\",\n"
            + "  \"minAmount\": \"20\",\n"
            + "  \"minInterest\": 5,\n"
            + "  \"partnerId\": 2,\n"
            + "  \"partnerCode\": \"T-1\",\n"
            + "  \"productCode\": \"舒服舒服222\",\n"
            + "  \"productIcon\": \"sdfsd\",\n"
            + "  \"productLabel\": \"sfsfsf\",\n"
            + "  \"productName\": \"斯蒂芬森发水电费222\",\n"
            + "  \"productSlogan\": \"斯蒂芬森\",\n"
            + "  \"province\": \"110000\",\n"
            + "  \"rejectDate\": \"20\",\n"
            + "  \"rejectPlatformFlag\": true,\n"
            + "  \"rejectPlatformUrl\": \"sdfsdf\",\n"
            + "  \"tenor\": \"3M,6M\",\n"
            + "  \"id\": 22,\n"
            + "  \"validateFlag\": true\n"
            + "}";

//        String url = urlPrefix + "/platform/add";
        String url = urlPrefix + "/platform/update";
        Header[] headers = HttpHeader.custom()
            .other("Content-Type", "application/json")
            .other("X-User-Token", "c034d4b3c708dfbebc150b08b37a9f67").build();

        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(jsonStr).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }


    @Test
    public void upOrDown() throws HttpProcessException {
        String url = urlPrefix + "/platform/upOrDown";
        String jsonStr = "{\n"
            + "    \"validateFlag\": true,\n"
            + "    \"idList\": [\n"
            + "        1,\n"
            + "        2,\n"
            + "        3\n"
            + "    ]\n"
            + "}";
        Header[] headers = HttpHeader.custom()
            .other("Content-Type", "application/json")
            .other("X-User-Token", "ba9b7484fceed673a5a02d473e1b7394").build();

        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(jsonStr).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("===z======================res=========================");
    }

    @Test
    public void batchDelete() throws HttpProcessException {
        String url = urlPrefix + "/platform/batchDelete";
        String jsonStr = "{\n"
            + "    \"idList\": [\n"
            + "        1,\n"
            + "        2,\n"
            + "        3\n"
            + "    ]\n"
            + "}";
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(jsonStr));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("===z======================res=========================");
    }
}
