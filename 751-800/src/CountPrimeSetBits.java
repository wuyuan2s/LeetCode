public class CountPrimeSetBits {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6,10));
        System.out.println(countPrimeSetBits(10,15));
        System.out.println(countPrimeSetBits(15,15));
    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            String strs = Integer.toBinaryString(i);
            strs = strs.replace("0", "");
            System.out.println(strs);
            if (isPrime(strs.length())) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

/**
 *  665772的二进制表示是0000 0000 0000 1010 0010 1000 1010 1100，所有的1都在质数位置。
 *
 *  方法二：判断质数优化
 * 注意到 题目中给出范围不会超过20位整数
 *  ，因此二进制中 1 的个数不会超过 1919，而不超过 19 的质数只有
 *
 * 2, 3, 5, 7, 11, 13, 17, 19
 * 2,3,5,7,11,13,17,19
 *
 * 我们可以用一个二进制数 \textit{mask}=665772=10100010100010101100_{2}mask=665772=10100010100010101100
 * 2
 * ​
 *   来存储这些质数，其中 \textit{mask}mask 二进制的从低到高的第 ii 位为 11 表示 ii 是质数，为 00 表示 ii 不是质数。
 *
 * 设整数 xx 的二进制中 11 的个数为 cc，若 \textit{mask}mask 按位与 2^c2
 * c
 *   不为 00，则说明 cc 是一个质数。
 *
 */
class Solution1 {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
//            Integer.bitCount(i): 返回i的二进制数中有多少个是1
//            665772：二进制1 的位置都为质数，他 与 一个数，不为0，则这个数为质数
//            665772右移i中一的个数位，再与 1，判断最右边（最低位）是否有一，如果有则是质数，没有则不是
            res += 665772 >> Integer.bitCount(i) & 1;
        }
        return res;
    }
}

/**
 * 整数最多有32个1，所以直接计算1~32中谁是素数，谁不是即可。(拒绝无意义的暴力)
 * 其实最多就20位，题目限制了数的大小最大只能到10^6
 */
class Solution2 {
    boolean[] prime = new boolean[20];

    private void init() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= 4; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j < 20; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public int countPrimeSetBits(int L, int R) {
        int cnt = 0;
        init();

        for (int i = L; i <= R; i++) {
            if (!prime[Integer.bitCount(i)]) {
                cnt++;
            }
        }

        return cnt;
    }
}