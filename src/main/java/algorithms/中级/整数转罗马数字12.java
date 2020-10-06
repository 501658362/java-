package algorithms.中级;

public class 整数转罗马数字12 {

    public static void main(String[] args) {
        整数转罗马数字12 solution = new 整数转罗马数字12();
        String pwwkew = solution.intToRoman(1994);
        System.out.println(pwwkew + " 1994" + "MCMXCIV".equals(pwwkew));
        System.out.println(pwwkew + " 58" + "58".equals(pwwkew));
    }

    public String intToRoman(int num) {

        int num1 = num / 1000;
        int num2 = (num - num1 * 1000) / 100;
        int num3 = (num - num1 * 1000 - num2 * 100) / 10;
        int num4 = (num - num1 * 1000 - num2 * 100 - num3 * 10);
        StringBuilder result = new StringBuilder();
        if (num1 > 0) {
            for (int i = 0; i < num1; i++) {
                result.append("M");
            }
        }
        this.get(num2, result, "C", "D", "M");
        this.get(num3, result, "X", "L", "C");
        this.get(num4, result, "I", "V", "X");

        return result.toString();

    }


    private void get(int num2, StringBuilder result, String s1, String s2, String s3) {
        if (num2 > 0) {
            if (num2 <= 5) {
                if (num2 <= 3) {
                    for (int i = 0; i < num2; i++) {
                        result.append(s1);
                    }
                } else {
                    for (int i = 0; i < 5 - num2; i++) {
                        result.append(s1);
                    }
                    result.append(s2);
                }

            } else {
                int x = 10 - num2;
                if (x > 1) {
                    result.append(s2);
                    for (int i = 0; i < 5 - x; i++) {
                        result.append(s1);
                    }
                } else {
                    result.append(s1);
                    result.append(s3);
                }
            }
        }
    }
}

