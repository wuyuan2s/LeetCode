/**
 * @author wuyuan
 * @since 2022-03-20 23:42
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        String reserveStr = new StringBuilder(str).reverse().toString();
        return reserveStr.equals(str);
    }
}
