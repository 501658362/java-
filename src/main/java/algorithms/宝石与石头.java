package algorithms;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2019/7/9
 */
public class 宝石与石头 {

    /**
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * <p>
     * 示例 1:
     * 输入: J = "aA", S = "aAAbbbb"
     * 输出: 3
     * 示例 2:
     * 输入: J = "z", S = "ZZ"
     * 输出: 0
     * 注意:
     * S 和 J 最多含有50个字母。
     *  J 中的字符不重复。
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numJewelsInStones("abc", "asdakgjdiqwasxnzaiucasdqc"));
    }

    static class Solution {
        public int numJewelsInStones(String j, String s) {
            // a vvvv a a ccc a a a
            // vvvv a a ccc a a a
            // vvvv a a ccc a a c
            char[] chars = j.toCharArray();
            int i = 0;
            for (char aChar : chars) {
                String charString = String.valueOf(aChar);
                int currentString = 0;
                i += getIndex(currentString, 0, charString, s);

            }
            return i;
        }

        private int getIndex(int count, int index, String str, String string) {
            int i = string.indexOf(str, index);
            if (i > -1) {
                count++;
                return getIndex(count, i + 1, str, string);
            }
            return count;
        }
    }
}
