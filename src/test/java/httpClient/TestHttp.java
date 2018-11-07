package httpClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiaxin.dream.utils.httpclient.common.HttpConfig;
import com.jiaxin.dream.utils.httpclient.exception.HttpProcessException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadPoolExecutor;
import model.OpenApiParams;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.junit.Test;
import com.jiaxin.dream.utils.httpclient.HttpClientUtil;
import com.jiaxin.dream.utils.httpclient.common.HttpHeader;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/9/2 21:21
 */
public class TestHttp {

    //    private String wldSecret = "8jifu87asdggas7nk0sjfhu85asd153";
    private String wldSecret = "5b66f77c880df4f9dfee51306899999";
    private String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJ9qLLYnladKSyFwhVXJe3gKbX1iqBlAXC1xxUraHu+ysX0PzNURPwRiHICSgTMt3O4JKNbYgDfVQC9KX0BlDL178yCPextFGblx96/Euwq5TYGOighV5pupEtierJZXifGVfTHfTsg/ypQKDYsyxyP/7kk1j4uiF+Ys+iYaiuJTAgMBAAECgYEAg3TPmAo+e2xlVhburNZwLYYT0dC4I9KR8JugAOCroCfv+tw7ofwNxjSNomythCGuzM/a0IhJ+0CsJBMlRvnNLWRnO/5lBag+/CebDS2uwFcdzxDNYqg/H0Wc8fGqvowoS2Rl9iyv8Xex/qA8+G36MX5Fh6EFcJWqNUktniZC3FkCQQD1pKd8ciXHR8GCzusgbxfR17SA1Kxk+hNK2jEDolJ4CfcSVm4tuQfWXAazFpYU+QXn1Mu1X7vI2OCLifShZv/dAkEApiLQrn4lhehreb43PWLoqKDYT3g59IGS/8KorskGzfR2d012dryvHAI2HLAKugqolPrsTPEhJNvQ3lF3vLtf7wJBALqZMYGfVINlRuKPPJ2OxpFpQnz7EVpDfZRG2yTfkbYOG9maPmgNPp7fmVdBuRCFeq75PyWwa33PAgP98A8LpyECQAHSmfWAHstETIGOa665uhG3igf9Kq2bClDSAuXAANobl30hlW4iDc3B3HQeHlACM+1Gf3csog90desqe6TPbXMCQQCg90/7CDf34a28ik/+5gNgDlHwnGNzk8tR+EZt8BpOQ6zZukcE2dPuA0HLH2ADAfpm6lfcHXP8JgukS+oraLHS";
    //    private String urlPrefix = "http://192.168.9.112:9006/gateway";
//    private String urlPrefix = "http://192.168.190.205:9006/gateway";
//    private String urlPrefix = "https://api.jldloan.com/risk-gateway-web";
//    private String urlPrefix = "http://192.168.190.205:8088/risk-gateway-web";
//    private String urlPrefix = "http://192.168.9.101/risk-gateway-web";
//    private String urlPrefix = "http://127.0.0.1:8082/thor/api/v1";
    private String urlPrefix = "http://japi-dev.wolaidai.com/thor-operation/api/v1";
//    private String urlPrefix = "http://101.fout.zyxr.com:2880/risk-gateway-web"; //http://112.fout.zyxr.com:2880/

    @Test
    public void findAllPartner() throws HttpProcessException {
        String url = urlPrefix + "/partner/findsBypartnerCode";
        String res = HttpClientUtil.get(HttpConfig.custom().url(url));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }
    @Test
    public void findProducts() throws HttpProcessException {
        String url = urlPrefix + "/partner/findProductsByPartnerCode?partnerCode=";
        String res = HttpClientUtil.get(HttpConfig.custom().url(url));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void testPostRequest() throws HttpProcessException {
        String url = urlPrefix + "/platform/findByCityOrProvince";
        Map<Object, Object> param = new HashMap<>();
        param.put("cityCode", "140800");
//        param.put("provinceCode","1");
//        param.put("hotFlag",true);
        param.put("pageNo", "1");
        param.put("pageSize", "20");
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(JSON.toJSONString(param)));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void testFindAllHotCity() throws HttpProcessException {
        String url = urlPrefix + "/platform/findHotCityNames";

        String res = HttpClientUtil.get(HttpConfig.custom().url(url));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void testPlatforms() throws HttpProcessException {
        Header[] headers = HttpHeader.custom()
            .other("Content-Type", "application/json")
            .other("X-User-Token", "b4c1c035c4e0008d00fcc20cebc6b970").build();

        String url = urlPrefix + "/platform/findHotCityNames";

        String res = HttpClientUtil.get(HttpConfig.custom().url(url).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void testfindByProductCode() throws HttpProcessException {
        String url = urlPrefix + "/platform/findByProductCode/AX-XJD";

        String res = HttpClientUtil.get(HttpConfig.custom().url(url));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }
//    findByProductCode/{productCode}

    @Test
    public void testaddPlatformRequest() throws HttpProcessException {
        String url = urlPrefix + "/platform/add";
        Map<Object, Object> param = new HashMap<>();
//        param.put("parterCode", "test66");
        param.put("icon", "http://web.wolaidai.com/webapp/yhd/img/platform-ax.png");
        param.put("city", "666");
        param.put("province", "666666");
        param.put("productCode", "AX-6");
        param.put("partnerId", "1");
//        param.put("pageNo","1");
//        param.put("pageSize","3");
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(JSON.toJSONString(param)));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    @Test
    public void testupDatePlatformRequest() throws HttpProcessException {
        String url = urlPrefix + "/platform/update";
        Map<Object, Object> param = new HashMap<>();
        param.put("id", 3);
        param.put("name", "test33");
        param.put("icon", "http://web.wolaidai.com/webapp/yhd/img/platform-ax.png");
        param.put("city", "222223");
        param.put("province", "3323");
//        param.put("productCode","AX-XJD4");
//        param.put("pageNo","1");
//        param.put("pageSize","3");
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(JSON.toJSONString(param)));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("=========================res=========================");
    }

    /**
     * 我来贷查询用户信息
     */
    @Test
    public void testgetUserInfo() throws Exception {
//        String url = "https://japi-fat.wolaidai.com/wall/api/v1/user/info";
//        String tokenurl = urlPrefix + "/token/accessToken";
        String url = "https://channels.wolaidai.com/wall/api/v1/user/info";
        String tokenurl = "https://api.jldloan.com/risk-gateway-web/token/accessToken";
        String mobile = "15863279927";
        String bizData = "{\"mobile\":\"" + mobile + "\"}";
        String html = HttpClientUtil
            .post(
                HttpConfig.custom().url(tokenurl).json(JSON.toJSONString(openApiParams(bizData))));
        JSONObject jsonObject = JSON.parseObject(html);
        if (jsonObject == null) {
            return;
        }
        JSONObject data =
            jsonObject.get("data") != null ? JSON.parseObject(jsonObject.get("data").toString())
                : null;

        if (data == null || data.get("token") == null) {
            return;
        }
        Header[] headers = HttpHeader.custom()
            .other("X-Partner-Code", "RT")
            .other("X-Product-Code", "RT-GXD")
            .other("Content-Type", "application/json")
            .other("X-User-Token", data.get("token").toString())
            .other("X-Source-Id", "1")
            .other("X-User-Mobile", mobile).build();
        System.out.println(
            HttpClientUtil.get(HttpConfig.custom().encoding("UTF-8").url(url).headers(headers)));

    }

    /**
     * 获取token
     */
    @Test
    public void testToken() throws Exception {

        String url = urlPrefix + "/token/accessToken";
        String bizData = "{\"mobile\":\"18822221112\"}";
        String html = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(JSON.toJSONString(openApiParams(bizData))));
        System.out.println("--------------html\n" + html);
    }

    /**
     * 构建基本参数
     */
    private OpenApiParams openApiParams(String bizData) {

        String str = "{ \"appId\":\"6192729A64EE4B9D8812EE4E14ACA90A\", \"bizData\":\"\", \"bizEnc\":0, \"encKey\":\"\", \"format\":\"json\", \"method\":\"test\", \"sign\":\"4ba9c971d4ea9e24ca8af8fa1e9a5eae\", \"signType\":\"SHA256withRSA\", \"timestamp\":\"2018-01-31 14:01:11\", \"version\":\"1.0\", \t\"nonceId\":\"960799872612884480\", \t\"callbackUrl\":\"\" } ";
        OpenApiParams openApiParams = JSON.parseObject(str, OpenApiParams.class);
        openApiParams.setTimestamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        openApiParams.setNonceId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        openApiParams.setBizData(bizData);
//        try {
//            Map<String, Object> signParams = ObjectMapUtil
//                .objectToMap(openApiParams, false, "sign", "encKey", "bizEnc", "callbackUrl");
//            SHA256withRSASign sign = new SHA256withRSASign(signParams, privateKey);
//            openApiParams.setSign(sign.sign());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (SignException e) {
//            e.printStackTrace();
//        }
        openApiParams.setCallbackUrl("http://192.168.190.250:8080/RiskWeb/risk/internal");
        return openApiParams;
    }

    @Test
    public void test() {
        StringBuffer sb = new StringBuffer();
        sb.append(",,,,,");
        sb.append(",").append("12");
        String[] arrayCityCode = sb.toString().split(",");
        System.out.println(JSON.toJSONString(arrayCityCode));
    }

}
