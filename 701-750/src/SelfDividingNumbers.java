import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(47, 85));
    }

    /**
     * 自己写的
     * @param left
     * @param right
     * @return
     */
    public static List<Integer> selfDividingNumber(int left, int right) {
        int[] array = new int[right];
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            char[] first = String.valueOf(i).toCharArray();
            boolean flag = true;
            for (char c: first) {
                int divisor = Integer.parseInt(String.valueOf(c));
                if (divisor == 0 || i % divisor != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }

        return list;
    }

    /** 官方写法
     *
     *
     * @param left
     * @param right
     * @return
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        int[] array = new int[right];
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            char[] first = String.valueOf(i).toCharArray();
            boolean flag = true;
            for (char c: first) {
                int divisor = Integer.parseInt(String.valueOf(c));
                if (divisor == 0 || i % divisor != 0) {
                    flag = false;
                    break;
                }
            }
            if (isDividing(i)) {
                list.add(i);
            }
        }

        return list;
    }

    public static boolean isDividing(int num) {
        int temp = num;
        boolean flag = true;
        while (temp > 0) {
            int divisor = temp % 10;
            temp = temp / 10;
            if (divisor == 0 || num % divisor != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
