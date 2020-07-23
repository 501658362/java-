package algorithms.简单;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 罗马数字转整数13 {

    public static void main(String[] args) {
        罗马数字转整数13 solution = new 罗马数字转整数13();
//        int i = solution.romanToInt("IV");
        int i = solution.romanToInt("III");
        System.out.println(1);
    }

    public int romanToInt(String s) {

        int value = getValue(s.charAt(s.length() - 1));
        int result = 0;
        for (int length = s.length() - 1; length >= 0; length--) {
            int num = getValue(s.charAt(length));
            if (num < value) {
                result -= num;
            } else {
                result += num;
            }
            value = num;
        }

        return result;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt1(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int end = s.length();
            while (i != end) {
                String num = s.substring(i, end);
                if (!map.containsKey(num)) {
                    end--;
                } else {
                    i = end - 1;
                    list.add(num);
                    break;
                }

            }

        }
        int result = 0;
        for (String key : list) {
            result += map.get(key);
        }
        return result;
    }
}
