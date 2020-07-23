package algorithms.简单;

public class 最长公共前缀14 {

    public static void main(String[] args) {
        最长公共前缀14 solution = new 最长公共前缀14();
        String[] strs = new String[2];
        strs[0] = "aa";
        strs[1] = "a";


        String s = solution.longestCommonPrefix(strs);
        System.out.println(1);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs != null && strs.length > 0) {
            String string1 = strs[0];
            String prefix = "";
            if (string1.length() > 0) {
                int i = 1;
                while (i <= string1.length()) {
                    String prefixTemp = string1.substring(0, i);
                    for (String str : strs) {
                        if (str != null) {
                            if (str.length() < i) {
                                return prefix;
                            } else {
                                if (!prefixTemp.equals(str.substring(0, i))) {
                                    return prefix;
                                }
                            }
                        }

                    }
                    prefix = prefixTemp;
                    i++;
                }

            }
            return prefix;
        }
        return "";
    }
}
