package algorithms;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2019/7/9
 */
public class 累加数_未实现 {

    /**
     * 累加数是一个字符串，组成它的数字可以形成累加序列。
     * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
     * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
     * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
     * 示例 1:
     * 输入: "112358"
     * 输出: true
     * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
     * 示例 2:
     * 输入: "199100199"
     * 输出: true
     * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
     * 进阶:
     * 你如何处理一个溢出的过大的整数输入?
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isAdditiveNumber("199100199"));
    }

    static class Solution {
        public boolean isAdditiveNumber(String num) {
            char[] chars = num.toCharArray();
            if (chars.length >= 3) {
                boolean isTrue = true;
                int length = chars.length;
                for (int i = 0; i < length; i++) {
                    if (i + 2 == length) {
                        break;
                    }
                    int i1 = Integer.parseInt(String.valueOf(chars[i]));
                    int i2 = Integer.parseInt(String.valueOf(chars[i + 1]));
                    int i3 = Integer.parseInt(String.valueOf(chars[i + 2]));

                    if (i1 + i2 != i3) {
                        isTrue = false;
                        break;
                    }

                }
                return isTrue;
            }

            return false;
        }
    }
}
