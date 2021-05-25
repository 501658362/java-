package algorithms.中级;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2021/5/25
 */
public class M_34_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        M_34_在排序数组中查找元素的第一个和最后一个位置 x = new M_34_在排序数组中查找元素的第一个和最后一个位置();
//        int[] ints1 = x.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7);
//        int[] ints = x.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        int[] ints = x.searchRange(new int[]{}, 0);
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {
        int start = bs(nums, target, true);
        int end = bs(nums, target, false);

        if (start >= nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, end};
    }

    private int bs(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                if (isLeft) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            } else if (cur < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (isLeft) {
            return left;
        }
        return left - 1;
    }
}
