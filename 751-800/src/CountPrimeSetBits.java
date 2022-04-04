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
 */
class Solution1 {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
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