package algorithms.简单;

public class E_704_二分查找 {

    public static void main(String[] args) {
        E_704_二分查找 solution = new E_704_二分查找();
        int search = solution.search(new int[]{1, 2, 3, 4}, 3);
        int search1 = solution.search(new int[]{1, 2, 3, 4}, 5);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                return mid;
            } else if (cur > target) {
                right = mid;
            } else if (cur < target) {
                left = mid + 1;
            }
        }

        return -1;
    }


}
