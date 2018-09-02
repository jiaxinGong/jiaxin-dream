package filterIp;

import java.util.Arrays;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/13 16:44
 */
public class findIp {

    String[] ipStrs = new String[]{"255.255.255.255", "1.1.1.1", "192.168.1.3", "192.168.1.7", "192.168.1.5",
        "192.168.196.145", "113.88.97.57"};
    Long[] longips = new Long[ipStrs.length];

    private Long ip2Long(String ip) {
        String[] ips = ip.split("\\.");
        Long result = 0L;
        result = (long) (Integer.parseInt(ips[0]) * Math.pow(256.0, 3));
        result += (long) (Integer.parseInt(ips[1]) * Math.pow(256.0, 2));
        result += (long) (Integer.parseInt(ips[2]) * Math.pow(256.0, 1));
        result += (long) (Integer.parseInt(ips[3]));
        return result;
    }

    @Test
    public void transferIpToLong() {
        int i = 0;
        for (String strip : ipStrs) {
            longips[i] = ip2Long(strip);
            i++;
        }
        Arrays.stream(longips).forEach(n -> System.out.println(n));
        insertSort(longips);
        System.out.println("======================================");
        Arrays.stream(longips).forEach(n -> System.out.println(n));

        System.out.println("find:" + binarySearch("255.255.255.255"));
    }

    private String convertLongToIp(long longIp) {
        StringBuilder sb = new StringBuilder();
        long f1 = longIp / (1 << 24);
        sb.append(f1).append(".");
        long s1 = longIp - f1 * (1 << 24);
        long f2 = s1 / (1L << 16);
        sb.append(f2).append(".");
        long s2 = s1 - f2 * (1L << 16);
        long f3 = s2 / (1L << 8);
        sb.append(f3).append(".");
        long s3 = s2 - f3 * (1L << 8);
        long f4 = s3;
        sb.append(f4);
        return sb.toString();
    }

    @Test
    public void t() {
        System.out.println(convertLongToIp(1901617465L));
        System.out.println(convertLongToIp(3232235781L));
        System.out.println(convertLongToIp(3232235783L));
    }

    public void insertSort(Long[] needSort) {
        for (int i = 1; i < needSort.length; i++) {
            int index = i - 1;
            Long temp = needSort[i];
            while (index >= 0 && temp < needSort[index]) {
                needSort[index + 1] = needSort[index];
                index--;
            }
            needSort[index + 1] = temp;
        }
        System.out.println("************************************");
        Arrays.stream(needSort).forEach(s -> System.out.println(s));
        System.out.println("************************************");
    }

    public String binarySearch(String ip) {
        Long ipLong = ip2Long(ip);
        int start = 0;
        int end = longips.length;
        int mid = (start + end) / 2;
        while (start <= end) {
            mid = (start + end) / 2;
            if (ipLong < longips[mid]) {
                end = mid - 1;
            } else if (ipLong > longips[mid]) {
                start = mid + 1;
            } else {
                return convertLongToIp(ipLong);
            }
        }
        return null;
    }
}
