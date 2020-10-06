package algorithms.简单;

public class 除数博弈1025 {

    public static void main(String[] args) {
        除数博弈1025 solution = new 除数博弈1025();
//        int i = solution.romanToInt("IV");
        boolean b = solution.divisorGame(999);
    }

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }


}
