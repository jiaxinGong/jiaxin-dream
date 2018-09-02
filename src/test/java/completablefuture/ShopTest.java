package completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/9 16:29
 */
public class ShopTest {

    List<Shop> shops = Arrays.asList(new Shop("AB"),
        new Shop("BC"), new Shop("DE"),new Shop("EF"));

    public List<String> findPrices(String product) {
        return shops.stream().map(shop -> String.format("%s price is %.2f",
            shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    public List<String> findPrices2(String product) {
        return shops.parallelStream().map(shop -> String.format("%s price is %.2f",
            shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    public List<String> findPrices3(String product){
        List<CompletableFuture<String>>  completableFutures =  shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f",
            shop.getName(), shop.getPrice(product))))
            .collect(Collectors.toList());
        return completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(new ShopTest().findPrices("abcd"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("duration:"+duration);
        System.out.println("=============================");
         start = System.nanoTime();
        System.out.println(new ShopTest().findPrices2("abcd"));
         duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("duration2:"+duration);
        System.out.println("===============================");
        start = System.nanoTime();
        System.out.println(new ShopTest().findPrices3("abcd"));
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("duration3:"+duration);
    }
}
