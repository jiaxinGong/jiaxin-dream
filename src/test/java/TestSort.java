import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <p>
 *
 * </p>
 *
 * @author gong.jiaxin
 * @since 2018/8/22 22:28
 */
public class TestSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 3;
        int[] arr = new int[num];
        for(int i = 1; i <= num; i++){
            System.out.println("输入第" + i + "个整数: ");
            int x = input.nextInt();
            arr[i-1] = x;
        }
        input.close();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
