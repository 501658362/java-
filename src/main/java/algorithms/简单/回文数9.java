package algorithms.简单;

public class 回文数9 {

    public static void main(String[] args) {
        回文数9 solution = new 回文数9();
        boolean au = solution.isPalindrome(-1221);
        System.out.println(1);
    }

    public boolean isPalindrome(int x) {

        String newN1 = new StringBuffer(String.valueOf(x)).reverse().toString();
        try {
            return Integer.parseInt(newN1) == x;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
