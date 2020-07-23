package algorithms.简单;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 有效的括号20 {

    public static void main(String[] args) {
        有效的括号20 solution = new 有效的括号20();


        boolean s = solution.isValid(
                "){");
        System.out.println(1);
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<String> stringStack = new Stack<>();
        for (String string : s.split("")) {
            switch (string) {
                case "[":
                    stringStack.push("]");
                    break;
                case "{":
                    stringStack.push("}");
                    break;
                case "(":
                    stringStack.push(")");
                    break;
                default:
                    if (stringStack.empty() || !string.equals(stringStack.pop())) {
                        return false;
                    }
            }
        }

        return stringStack.empty();

    }

    public boolean isValid1(String s) {
        // 以下写法不支持 ([)]应该返回false 但是返回true了

        if (s == null || s.length() == 0 || s.indexOf(")") < s.indexOf("(") || s.indexOf("]") < s.indexOf("[") || s.indexOf("}") < s.indexOf("{")) {
            // 判断非法
            return false;
        }

        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("(", ")");
        keyMap.put("[", "]");
        keyMap.put("{", "}");

        // 判断是不是每个(都是对应的)前面
        for (String key : keyMap.keySet()) {
            int i = 0;
            int end = 0;
            while (i >= 0) {
                int start = s.indexOf(key, i);
                if (end == 0) {
                    end = start;
                }
                end = s.indexOf(keyMap.get(key), end + 1);
                if ((start == -1 && end > 0) || (end == -1 && start > 0)) {
                    return false;
                }
                if (start == -1 && end == -1) {
                    i = -1;
                    continue;
                }
                i = start + 1;
            }

        }
        return true;
    }
}
