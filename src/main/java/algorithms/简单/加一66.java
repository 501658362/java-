package algorithms.简单;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 加一66 {

    public static void main(String[] args) {
        加一66 t = new 加一66();
        int[] tt = new int[4];
        tt[0] = 9;
        tt[1] = 9;
        tt[2] = 9;
        tt[3] = 9;
        int[] ints = t.plusOne(tt);
        System.out.println(1);
    }

    public int[] plusOne(int[] digits) {
        int add = 1;
        int temp = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (add > 0) {
                int result = digits[i] + add;
                if (result >= 10) {
                    add = 1;
                    digits[i] = result % 10;
                    if (i == 0) {
                        temp = 1;
                    }
                } else {
                    add = 0;
                    digits[i] = result;
                }
            } else {
                break;
            }
        }
        if (temp > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = temp;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }
}
