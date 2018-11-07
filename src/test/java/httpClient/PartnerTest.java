package httpClient;

import com.alibaba.fastjson.JSON;
import com.jiaxin.dream.utils.httpclient.HttpClientUtil;
import com.jiaxin.dream.utils.httpclient.common.HttpConfig;
import com.jiaxin.dream.utils.httpclient.common.HttpHeader;
import com.jiaxin.dream.utils.httpclient.exception.HttpProcessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.junit.Test;

public class PartnerTest {

    private String urlPrefix = "http://127.0.0.1:8082/thor/api/v1";
//    private String urlPrefix = "http://japi-dev.wolaidai.com/thor-operation/api/v1";

    @Test
    public void addPartner() throws HttpProcessException {
        String url = urlPrefix + "/partner/add";
        Map<Object, Object> param = new HashMap<>();
//        private Long id;
//        private String partnerCode;
//        private String partnerName;
//        private String partnerIcon;
//        private Date updatedAt;
//        private Boolean deleteFlag;

//        deleteFlag: true
//        partnerCode: "rookie"
//        partnerIcon: "rookie-logo"
//        partnerName: "rookie-test"

        Header[] headers = HttpHeader.custom()
            .other("Content-Type", "application/json")
            .other("X-User-Token", "c73fa0730fc79f503abc1ccd6e13030d").build();

        param.put("partnerCode", "P-003");
        param.put("partnerName", "PName-test03");
        param.put("partnerIcon", "http://web.wolaidai.com/webapp/yhd/img/platform-bm.png");
//        param.put("deleteFlag", true);
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(JSON.toJSONString(param)).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("===z======================res=========================");

    }

    @Test
    public void updatePartner() throws HttpProcessException {
        String url = urlPrefix + "/partner/update";
        Map<Object, Object> param = new HashMap<>();
        param.put("partnerCode", "P-000");
        param.put("partnerName", "PName-000");
        param.put("partnerIcon", "http://web.wolaidai.com/webapp/yhd/img/platform-bm.png");
        param.put("deleteFlag", true);
        System.out.println(JSON.toJSONString(param));
        Header[] headers = HttpHeader.custom()
            .other("Content-Type", "application/json")
            .other("X-User-Token", "cdd4c48c5712268dd1fc0c54eac7be57").build();
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(JSON.toJSONString(param)).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("===z======================res=========================");
    }

    @Test
    public void listPartners() throws HttpProcessException {
        String url = urlPrefix + "/partner/list";
        Map<Object, Object> param = new HashMap<>();
//        param.put("id", 1);
//        param.put("partnerCode", "T-1");
//        param.put("partnerName", "Apple");
        PageParam pageParam = new PageParam();
        pageParam.setPageNo(1);
        pageParam.setPageSize(20);
        param.put("pageParam", pageParam);
        Header[] headers = HttpHeader.custom()
            .other("Content-Type", "application/json")
            .other("X-User-Token", "2700c71a7cde18b086adb2cd9c056c96").build();

        String jsonParam = JSON.toJSONString(param);
        System.out.println("---------------");
        System.out.println(jsonParam);
        System.out.println("------------------");
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(jsonParam).headers(headers));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("===z======================res=========================");
    }

    //    findProducts
    @Test
    public void findProducts() throws HttpProcessException {
        String url = urlPrefix + "/partner/findProducts";
        Map<Object, Object> param = new HashMap<>();
        param.put("partnerName", "Apple");
//        param.put("partnerCode", "T-2");
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(JSON.toJSONString(param)));
        System.out.println("=========================res=========================");
        System.out.println(res);
        System.out.println("===z======================res=========================");
    }

    @Test
    public void t() throws ParseException {
        List<Long> list = new ArrayList<>();
        Long e1 = new Long(100000000000L);
        Long e2 = new Long(100000000001L);
        Long e3 = new Long(100000000002L);

        list.add(e1);
        list.add(e2);
        list.add(e3);

        List<Long> list2 = new ArrayList<>();
        list2.add(100000000001L);
        list2.add(100000000002L);

        list.stream().filter(l -> !list2.contains(l)).forEach(s->{
            System.out.println(s);
        });

    }


}
