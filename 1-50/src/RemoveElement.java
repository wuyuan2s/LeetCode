public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int tail = nums.length - 1;
        while (i <= tail) {
            if (nums[i] == val) {
                nums[i] = nums[tail];
                tail--;
            } else {
                i++;
            }
        }
        return tail + 1;
    }

    /**
     * 双指针解法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement002(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    /**
     * 双指针解法 --- 优化版
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElementBest(int[] nums, int val) {
        int right = nums.length;
        int left = 0;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else left++;
        }
        return ++left;
    }

}