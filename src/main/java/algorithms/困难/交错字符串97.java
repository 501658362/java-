package algorithms.困难;

public class 交错字符串97 {
//    给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
//
//    示例 1:
//
//    输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//    输出: true
//    示例 2:
//
//    输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//    输出: false
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/interleaving-string

    public static void main(String[] args) {
        交错字符串97 solution = new 交错字符串97();
//        int i = solution.romanToInt("IV");
//        boolean interleave = solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        boolean interleave = solution.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        System.out.println(1);
    }

    //    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length() + s2.length() != s3.length()){
//            return false;
//        }
//        List<String> collect3 = new ArrayList<>(Arrays.asList(s3.split("")));
//        List<String> collect2 = new ArrayList<>(Arrays.asList(s2.split("")));
//        List<String> collect1 = new ArrayList<>(Arrays.asList(s1.split("")));
//        for (char c : s1.toCharArray()) {
//            s3.indexOf(c);
//            collect3.indexOf()
//        }
//
//
//        return false;
//    }
    int cur1 = 0, cur2 = 0, cur3 = 0; //三个指针，分别指向s1,s2,s3已经搜索到的位置

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) {
            return true;
        } else if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // 返回回溯结果
        return recursive(s1, s2, s3);
    }

    public boolean recursive(String s1, String s2, String s3) {
        // 递归终止条件：如果s3已经全部搜索完，则表明符合题意，返回true
        if (cur3 >= s3.length()) {
            return true;
        }
        if (cur1 < s1.length() && s3.charAt(cur3) == s1.charAt(cur1)) {
            // 继续下一层回溯
            cur1 += 1;
            cur3 += 1;
            if (recursive(s1, s2, s3)) {
                return true;
            }
            // 还原指针
            cur1 -= 1;
            cur3 -= 1;
        }
        if (cur2 < s2.length() && s3.charAt(cur3) == s2.charAt(cur2)) {
            cur2 += 1;
            cur3 += 1;
            if (recursive(s1, s2, s3)) {
                return true;
            }
            cur2 -= 1;
            cur3 -= 1;
        }
        return false;
    }

}
