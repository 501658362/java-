package algorithms.困难;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/18
 */
public class H_4_寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        H_4_寻找两个正序数组的中位数 x = new H_4_寻找两个正序数组的中位数();
        //int[] nums1 = {1, 2, 3, 4, 6, 7};
        //int[] nums2 = {1, 2, 4, 6};

        int[] nums1 = {};
        int[] nums2 = {1};

        double medianSortedArrays = x.findMedianSortedArrays(nums1, nums2);
        System.out.println();
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int[] result = null;
        if (nums1 == null && nums2 != null) {
            result = nums2;
        }
        if (nums1.length == 0 && nums2.length > 0) {
            result = nums2;
        }
        if (nums1 != null && nums2 == null) {
            result = nums1;
        }
        if (nums1.length > 0 && nums2.length == 0) {
            result = nums1;
        }
        if (result == null) {
            int n1L = nums1.length;
            int n2L = nums2.length;
            result = new int[n1L + n2L];
            int c = 0;

            int i = 0;
            int j = 0;

            while (true) {

                if (nums1[i] < nums2[j]) {
                    result[c++] = nums1[i++];
                } else {
                    result[c++] = nums2[j++];
                }

                if (i == n1L) {
                    while (j < n2L) {
                        result[c++] = nums2[j++];
                    }
                    break;
                } else if (j == n2L) {
                    while (i < n1L) {
                        result[c++] = nums1[i++];
                    }
                    break;
                }

            }
        }

        int length = result.length;
        double x = 0;
        if (length % 2 == 0) {
            x = result[length / 2] + result[length / 2 - 1];
            x = x / 2;

        } else {
            x = result[length / 2];
        }
        return x;
    }
}
