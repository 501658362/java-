package algorithms.简单;

public class 搜索插入位置35 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        搜索插入位置35 solution = new 搜索插入位置35();
        int[] strs = new int[1];
        strs[0] = 1;


        int i = solution.searchInsert(strs, 2);
        System.out.println(1);
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1) {
            if (nums[0] >= target) {
                return 0;
            } else {
                return 1;
            }
        }
        while (start < end) {
            // 避免溢出
            int mid = start + (end - start) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            }
            if (num > target) {
                // 说明下标需要往前移动 0-100改为 0-50
                end = mid;
            } else {
                // 说明下标需要往后移动
                start = mid;
                if (start + 1 == end) {
                    if (nums[end] < target) {
                        return end + 1;
                    } else {
                        return start + 1;
                    }
                }
            }
        }
        return 0;
    }
}
