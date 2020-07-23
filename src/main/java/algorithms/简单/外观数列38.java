package algorithms.简单;

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * <p>
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * <p>
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * <p>
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * <p>
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 外观数列38 {


    public static void main(String[] args) {
        外观数列38 solution = new 外观数列38();
        String s = solution.countAndSay(6);
        System.out.println(1);
    }

    public String countAndSay(int n) {
        String start = "1";
        if (n == 1) {
            return start;
        }

        int i = 1;
        while (i != n) {
            i++;
            char[] chars = start.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;
            for (int j = 0; j < chars.length; j++) {

                int end = j + 1;
                while (end < chars.length) {
                    if (chars[j] == chars[end]) {
                        count++;
                        end++;
                    } else {
                        break;
                    }
                }
                stringBuilder.append(count).append(chars[j]);
                if (count > 1) {
                    j = end - 1;
                }
                count = 1;
                if (end + 1 == chars.length) {
                    stringBuilder.append(1).append(chars[end]);
                    break;
                }
            }
            start = stringBuilder.toString();

        }

        return start;
    }

}
