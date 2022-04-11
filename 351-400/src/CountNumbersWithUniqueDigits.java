import java.util.*;

public class CountNumbersWithUniqueDigits {

    public static void main(String[] args) {
//        System.out.println(countNumbersWithUniqueDigits(8));
        System.out.println(countNumbersWithUniqueDigits003(8));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        double pow = Math.pow(10, n);
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < pow; i++) {
            String s = String.valueOf(i);
            char[] chars = s.toCharArray();
            boolean flag = true;
            Set<Character> set = new HashSet<>(2);

            for (char c : chars) {
                if (!set.add(c)) {
                    flag = false;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list.size();
    }

    /**
     * 打表
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了24.23%的用户
     * 2022年4月8日 11:07
     */
    public int countNumbersWithUniqueDigitsDaBiao(int n) {
        return new int[]{1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851}[n];
    }

    /**
     * 找规律，除了n==0的情况，其他位数的数字数就是9*A(9)(n-1)：
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.9 MB, 在所有 Java 提交中击败了67.75%的用户
     */
    public int countNumbersWithUniqueDigits002(int n) {
        if (n == 0) {
            return 1;
        }
        int count = 9, ans = 9;
        for (int i = 2; i <= n; i++) {
            count *= (11 - i);
            ans += count;
        }
        return 1 + ans;
    }

    /**
     * f(0)=1
     * f(1)=10
     * f(2)=9*9+f(1)
     * f(3)=9*9*8+f(2)
     * f(4)=9*9*8*7+f(3)
     * 左边开始数
     * 首位数不取 0 其他位数可以取 0，下一位比前一位取法少一种，因为不能重复
     * 首位数取 0 时就是 f(n-1)的数量
     */
    public static int countNumbersWithUniqueDigits003(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 9;
        for (int i = 1; i < n; i++) {
            ans = ans * (10 - i);
        }
        return ans + countNumbersWithUniqueDigits003(n - 1);
    }
}
