public class SearchInsert {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1}, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int size = nums.length - 1;
        if (target > nums[size]) {
            return size + 1;
        }
        if (target == nums[size]) {
            return size;
        }
        for (int i = 0; i <= size; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }

        return 0;
    }

    public static int searchInsertBetter(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }
}
