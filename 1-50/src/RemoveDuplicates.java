public class RemoveDuplicates {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,2};
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 优化版：代码更简洁
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int i = 0;
        // 因为数组有序，所以只需要用++i来标记从 下标 0 开始，后面只要遇到不等于最后更新的下标 i 上的数值，
        // 则在 数组下标为 i 的下一位（即 ++i）更新为这个不相等的值即可
        for (int k = i+1; k < nums.length ; k++) {
            if(nums[i]!=nums[k]){
                nums[++i]=nums[k];
            }
        }
        return i+1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        // 双指针
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }
}
