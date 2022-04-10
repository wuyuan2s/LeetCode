import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 滑动窗口
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 63.38%
     * 的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringSet(String s) {
        int r = 0, l = 0, res = 0;
        HashSet<Character> set = new HashSet<>();
        while (r < s.length()) {
            char c = s.charAt(r++);
            while (set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res, set.size());
        }
        return res;
    }

    /**
     * 以这个字符串为例：abcabcbb，当i等于3时，也就是指向了第二个a, 此时我就需要查之前有没有出现过a,
     * 如果出现了是在哪一个位置出现的。然后通过last[index] 查到等于1,
     * 也就是说，如果start 依然等于0的话，那么当前窗口就有两个a了，也就是字符串重复了，
     * 所以我们需要移动当前窗口的start指针，移动到什么地方呢？
     * 移动到什么地方，窗口内就没有重复元素了呢？
     * 对了，就是a上一次出现的位置的下一个位置，就是1 + 1 = 2。当start == 2, 当
     * 前窗口就没有了重复元素，那么以当前字符为结尾的最长无重复子串就是bca,然后再和之前的res取最大值。
     * 然后i指向后面的位置，按照同样思路计算。
     *
     * @param s
     * @return 1ms 超过100 %
     */
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        int n = s.length();

        int res = 0;
        // 窗口开始位置
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            // 当前窗口位置
            start = Math.max(start, last[index]);
            res = Math.max(res, i - start + 1);
            last[index] = i + 1;
        }

        return res;
    }
}
