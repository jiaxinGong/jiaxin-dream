package foxconnTest;

import com.jiaxin.dream.utils.httpclient.HttpClientUtil;
import com.jiaxin.dream.utils.httpclient.common.HttpConfig;
import com.jiaxin.dream.utils.httpclient.common.HttpHeader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.apache.http.Header;
import org.junit.Test;

public class Publish {

    // 生产 别瞎搞
    private String fatUrlPrefix = "https://sa.wolaidai.com/api/deliveries/deploy/";

    Header[] headers = HttpHeader.custom()
        .other("Content-Type", "application/json")
        .other("authorization",
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NDEzOTUxMjQsImlhdCI6MTU0MDc5MDMyNCwic3ViIjoxNjV9.kdcvtv_Ik5-V4IrxdsUgPcw2JsjZA7DsHTrzLbeAR_I")
        .build();

    @Test
    public void p() throws Exception {
        int id = 38685;
        String url = fatUrlPrefix + id;
        String bodyJson = "{\n"
            + "    \"pushAdminId\": " + id + ",\n"
            + "    \"name\": \"foxconn-approval-center\",\n"
            + "    \"zone\": \"fat\"\n"
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

    @Test
    public void testNull(){
//        Long l = null;
//        System.out.println(l > 0);
        LocalDate localDate = LocalDate.now();
        localDate.minus(1, ChronoUnit.MONTHS);
        System.out.println(localDate.minus(1, ChronoUnit.MONTHS).toString());
    }
}
