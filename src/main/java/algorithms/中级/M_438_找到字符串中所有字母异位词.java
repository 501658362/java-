package algorithms.中级;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2021/5/26
 */
public class M_438_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        M_438_找到字符串中所有字母异位词 c = new M_438_找到字符串中所有字母异位词();
        List<Integer> b = c.findAnagrams("cbaebabacd", "abc");
        System.out.println();
    }

    public List<Integer> findAnagrams(String raw, String target) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (final char c : target.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < raw.length()) {
            char cur = raw.charAt(right);
            right++;
            if (needMap.containsKey(cur)) {
                windowMap.put(cur, windowMap.getOrDefault(cur, 0) + 1);
                if (windowMap.get(cur).equals(needMap.get(cur))) {
                    valid++;
                }
            }

            while (right - left >= target.length()) {
                if (valid == needMap.size()) {
                    res.add(left);
                }
                char lc = raw.charAt(left);
                left++;
                if (needMap.containsKey(lc)) {
                    if (windowMap.get(lc).equals(needMap.get(lc))) {
                        valid--;
                    }
                    windowMap.put(lc, windowMap.get(lc) - 1);
                }
            }
        }

        return res;
    }
}
