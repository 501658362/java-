package algorithms.中级;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2021/5/26
 */
public class M_567_字符串的排列 {

    public static void main(String[] args) {
        M_567_字符串的排列 c = new M_567_字符串的排列();
        Map<String, Integer> needMap = new HashMap<>();
        Map<String, Integer> windowMap = new HashMap<>();
        needMap.put("1", 1);
        windowMap.put("1", 1);
        boolean equals = needMap.equals(windowMap);
//        boolean b = c.checkInclusion("abc", "eidbaooo");
//        boolean b = c.checkInclusion("adc", "dcda");
        boolean b = c.checkInclusion("ab", "eidboaoo");
        System.out.println();
    }

    public boolean checkInclusion(String target, String rawData) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (final char c : target.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < rawData.length()) {
            char c = rawData.charAt(right);
            right++;
            if (needMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(needMap.get(c))) {
                    valid++;
                }
            }

            while (right - left >= target.length()) {
                if (valid == needMap.size()) {
                    return true;
                }
                char lf = rawData.charAt(left);
                left++;
                if (needMap.containsKey(lf)) {
                    if (windowMap.get(lf).equals(needMap.get(lf))) {
                        valid--;
                    }
                    windowMap.put(lf, windowMap.get(lf) - 1);
                }
            }

        }
        return false;
    }
}
