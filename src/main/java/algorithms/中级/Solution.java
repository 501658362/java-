package algorithms.中级;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String pwwkew = solution.convert("AB", 1);
        /**
         *
         * M   C
         * C X I
         * M   V
         */
    }

    public String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows == 1) {
            return s;
        }
        // 一列+斜线可以容纳几个
        double c = 2 * numRows - 2;
        // 长度
        int l = s.length();
        // 有几列
        int w = (int) Math.ceil(l / c);

        // 两列之间有几个数
        int other = numRows - 2;
        //String[][] array = new String[numRows][w * (other + 1)];
        StringBuilder stringBuilder = new StringBuilder();
        for (int n = 0; n < numRows; n++) {
            int wp = 0;
            for (int wi = 0; wi < w; wi++) {
                int p = (int) (n + 1 + c * wi);
                // 超出字符串长度了
                if (p > l) {
                    continue;
                }
                // array[n][wp] = s.substring(p - 1, p);
                stringBuilder.append(s.substring(p - 1, p));
                wp++;
                // 是否有斜线的行
                boolean flag = other > 0 && (n != 0 && n != numRows - 1);
                if (flag) {
                    int cnum = (int) (1 + c * wi + 1 + c * (wi + 1));
                    int p1 = cnum - p;
                    if (p1 > l) {
                        continue;
                    }
                    //array[n][wp] = s.substring(p1 - 1, p1);
                    stringBuilder.append(s.substring(p1 - 1, p1));
                    wp++;
                }
            }


        }

        return stringBuilder.toString();
    }
}

