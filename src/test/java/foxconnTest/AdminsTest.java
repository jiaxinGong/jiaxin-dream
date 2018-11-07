package foxconnTest;

import com.jiaxin.dream.utils.httpclient.HttpClientUtil;
import com.jiaxin.dream.utils.httpclient.common.HttpConfig;
import com.jiaxin.dream.utils.httpclient.common.HttpHeader;
import org.apache.http.Header;
import org.junit.Test;

public class AdminsTest {

    private String urlPrefix = "http://127.0.0.1:8080/foxconn-approval-center/api/v1";// 本地
    private String fatUrlPrefix = "https://japi-fat.wolaidai.com/foxconn-approval-center/api/v1";// fat

    Header[] headers = HttpHeader.custom()
        .other("Content-Type", "application/json")
        .other("X-User-Mobile", "18026986473")
        .other("X-Access-Token", "e582d2612ba14601a71250735e5bdb31")
        .build();

    /**
     * 登录
     */
    @Test
    public void login() throws Exception {
        headers = HttpHeader.custom()
            .other("Content-Type", "application/json")
            .build();

        String url = fatUrlPrefix + "/login";
        String bodyJson = "{\n"
            + "    \"username\": \"18026986473\",\n"
            + "    \"password\": \"1234567\"\n"
            + "}";
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(bodyJson).headers(headers));
        print(res);
    }

    /**
     * 添加用户
     */
    @Test
    public void addAdmins() throws Exception {
        String url = fatUrlPrefix + "/addAdmins";

        String bodyJson = "{\n"
            + "    \"mobile\": \"18026986474\",\n"
            + "    \"userName\": \"jiaxin2\",\n"
            + "    \"isSuper\": true,\n"
            + "    \"encryptedPassword\": \"123456\"\n"
            + "}";
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(bodyJson).headers(headers));
        print(res);
    }


    /**
     * 修改用户
     */
    @Test
    public void updateAdmins() throws Exception {

        String url = fatUrlPrefix + "/updateAdmins";

        String bodyJson = "{\n"
            + "    \"id\": 23,\n"
            + "    \"status\": \"1\"\n"  // 0：正常 | 1：休假 | 2：离职
            + "}";
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(bodyJson).headers(headers));
        print(res);
    }

    /**
     * 修改密码
     */
    @Test
    public void changePassword() throws Exception {

        String url = fatUrlPrefix + "/changePassword";

        String bodyJson = "{\n"
            + "    \"password\": \"1234567\"\n"
            + "}";
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(bodyJson).headers(headers));
        print(res);
    }

    /**
     * 重置密码
     */
    @Test
    public void resetPassword() throws Exception {
        headers = HttpHeader.custom()
            .other("Content-Type", "application/json")
            .other("X-User-Mobile", "18026986473")
            .other("X-Access-Token", "00482f4269ae4590aba0c713ab8d15ad")
            .build();
        String url = fatUrlPrefix + "/resetPassword";

        String bodyJson = "{\n"
            + "    \"resetMobile\": \"18026986474\"\n"
            + "}";
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(bodyJson).headers(headers));
        print(res);
    }

    /**
     * 管理员列表
     * @param
     */
    @Test
    public void getAdminsList() throws Exception {
        String url = fatUrlPrefix + "/getAdminsList";
        String res = HttpClientUtil.get(HttpConfig.custom().url(url).headers(headers));
        print(res);
    }


    private void print(Object o) {
        System.out.println("----------------");
        System.out.println(o);
        System.out.println("----------------");
    }
}
