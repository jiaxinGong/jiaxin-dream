package foxconnTest;

import com.alibaba.fastjson.JSON;
import com.jiaxin.dream.utils.httpclient.HttpClientUtil;
import com.jiaxin.dream.utils.httpclient.common.HttpConfig;
import com.jiaxin.dream.utils.httpclient.common.HttpHeader;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class Publish {

    // fat 别瞎搞
    private String fatUrlPrefix = "https://sa.wolaidai.com/api/deliveries/deploy/";

    Header[] headers = HttpHeader.custom()
        .other("Content-Type", "application/json")
        .other("authorization",
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NjY3ODIxODAsImlhdCI6MTU2NjE3NzM4MCwic3ViIjoxNjV9.dVtOkAuDwz2a7SSPzn5MU4oYjeW7jnK7S1YHnEZvi5k")
        .build();

    @Test
    public void p() throws Exception {
        int id = 112310;
        String url = fatUrlPrefix + id;
        String bodyJson = "{\n"
            + "    \"pushAdminId\": " + id + ",\n"
//            + "    \"name\": \"thor-operation\",\n"
//            + "    \"name\": \"thor-credit\",\n"
//            + "    \"name\": \"management-iam\",\n"
            + "    \"name\": \"captain\",\n"
//            + "    \"name\": \"channel-biz\",\n"
//            + "    \"name\": \"large-amount-bank\",\n"
            + "    \"zone\": \"fat\"\n"
            + "}";
        String res = HttpClientUtil
            .post(HttpConfig.custom().url(url).json(bodyJson).headers(headers));

        print(res);
    }


    private void print(Object o) {
        System.out.println("--------ฅʕ•̫͡•ʔฅ--------");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(new Date()));
        System.out.println(o);
        System.out.println("--------ฅʕ•̫͡•ʔฅ--------");
    }

    @Test
    public void testNull(){
//        Long l = null;
//        System.out.println(l > 0);
//        LocalDate localDate = LocalDate.now();
//        localDate.minus(1, ChronoUnit.MONTHS);
//        System.out.println(localDate.minus(1, ChronoUnit.MONTHS).toString());
       /* String str = "DESC";
        String regex = "^ASC$|^DESC$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }*/
       /*Long long1 = new Long(199);
       Long long2 = new Long(199);
        System.out.println(long1.equals(long2));
        System.out.println(Objects.equals(long1,long2));*/
        /*List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println(list.subList(0,0));
        System.out.println(list.subList(0,1));
        System.out.println(list.subList(0,2));
        System.out.println(list.subList(0,3));
        System.out.println(list.subList(0,4));*/
        /*A a = new A();
        a.date = new Date();
        B b = new B();
        BeanUtils.copyProperties(a,b);
        System.out.println(b);
        System.out.println(JSON.toJSON(b));*/
//        System.out.println("required".compareTo("optional"));
//        System.out.println(UUID.randomUUID()+"");
        Long l = 1L;
        String s = "1";
        System.out.println(Objects.equals(l+"",s));
    }

    class A{
        public Date date;
    }
    class B{
        public LocalDateTime date;
    }
}
