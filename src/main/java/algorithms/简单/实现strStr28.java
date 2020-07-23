package algorithms.简单;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 实现strStr28 {

    public static void main(String[] args) {
        实现strStr28 solution = new 实现strStr28();
//        int i = solution.strStr("12345236", "236");

        int i = solution.strStr("aaaaab", "ab");
        // 4
//        int i = solution.strStr("mississippi", "issip");
        System.out.println(1);
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int length = needle.length();
        if (haystack.length() < length) {
            return -1;
        }
        String[] needleArray = needle.split("");
        String[] hayStackArray = haystack.split("");
        int pos = 0;
        boolean flag = false;
        int start = 0;

        our:
        for (int j = 0; j < needleArray.length; j++) {
            if (pos >= hayStackArray.length) {
                return -1;
            }

            for (int i = pos; i < hayStackArray.length; i++) {
                if (hayStackArray[i].equals(needleArray[j])) {
                    pos = i + 1;
                    if (!flag) {
                        start = i;
                        flag = true;
                    }
                    continue our;
                } else {
                    if (flag) {
                        pos = start + 1;
                        j = -1;
                        flag = false;
                        continue our;
                    }
                }
            }
            if (j == 0 && !flag) {
                return -1;
            }
        }

        if (!flag) {
            return -1;
        }
        return start;
    }
}
