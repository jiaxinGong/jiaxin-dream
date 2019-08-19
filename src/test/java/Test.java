import com.alibaba.dubbo.common.URL;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiaxin.dream.utils.BeanConvertUtil;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/18 9:59
 */
public class Test {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        /*int a = 128;
        System.out.println((byte) a);
        int b = 129;
        System.out.println((byte) b);
        int c = 255;
        System.out.println((byte) c);
        int d = 256;
        System.out.println((byte) d);
        int e = 257;
        System.out.println((byte) e);
        StringBuffer sb = new StringBuffer();
        sb.append("");

        double hh = 0.00000101;
        System.out.println("hh:"+hh);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("getAndAdd=" + atomicInteger.getAndAdd(1));
        System.out.println("addAndGet=" + atomicInteger.addAndGet(1));*/

        /*String s = "验证码：6666，打死都不要告诉别人哦！";
        try {
            String e = URLEncoder.encode(s, "GBK");
            System.out.println(e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        String mobile = "18026986473";

        JSONObject reJson = new JSONObject();
        reJson.put("mobile", mobile);
//        String encryptData = RSAUtils.encryptByPublicKey(reJson.toString(), publicKey);//加密，输出已经进行Base64 encode处理
//        String signData = RSAUtils.signByPrivateKey(encryptData, privateKey, "UTF-8");//加签，输出已经进行Base64 encode处理
        Date date = new Date();

    }


    @org.junit.Test
    public void test() {
        A a = new A();
        a.setDelete(false);
        a.setId(1);
        a.setName("Tom");
        Map<String, Object> map = BeanConvertUtil.convertBean2Map(a,true);
        System.out.println(map);
    }

    public class A{
        private Integer id;
        private String name;
        private boolean delete;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isDelete() {
            return delete;
        }

        public void setDelete(boolean delete) {
            this.delete = delete;
        }
    }
}
