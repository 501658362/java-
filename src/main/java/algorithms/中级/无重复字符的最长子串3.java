package algorithms.中级;

import com.google.common.collect.Lists;

import java.util.*;

public class 无重复字符的最长子串3 {

    public static void main(String[] args) {
        无重复字符的最长子串3 solution = new 无重复字符的最长子串3();
        int pwwkew = solution.lengthOfLongestSubstring("au");
        System.out.println(1);
    }

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int maxlength = 1;

        for (int i = 0; i < s.length(); i++) {
            List<Character> characterList = new ArrayList<>(s.length());
            int end = i + 1;
            characterList.add(s.charAt(i));
            while (end < s.length()) {
                if (characterList.contains(s.charAt(end))) {
                    if (characterList.size() > maxlength) {
                        maxlength = characterList.size();
                    }
                    // 结束white循环
                    end = s.length();
                } else {
                    characterList.add(s.charAt(end));
                    end++;
                }

            }

            if (end == s.length()) {
                if (characterList.size() > maxlength) {
                    maxlength = characterList.size();
                }
            }

        }
        return maxlength;
    }

    public int lengthOfLongestSubstring1(String s) {
        List<String> list = Lists.newArrayList();
        String[] split = s.split("");
        int max = 0;
        int length = s.length();
        Map<String, List<Integer>> map = new HashMap<>();
        for (String char1 : split) {
            int i = s.indexOf(char1);
            while (i > -1) {
                if (map.containsKey(char1)) {
                    if (!map.get(char1).contains(i)) {
                        map.get(char1).add(i);
                    }
                } else {
                    map.put(char1, Lists.newArrayList(i));
                }
                i = s.indexOf(char1, i + 1);
            }
        }
        List<Integer> allList = Lists.newArrayList();
        for (List<Integer> value : map.values()) {
            if (value.size() > 1) {
                allList.addAll(value);
            }
        }
        Collections.sort(allList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < allList.size(); i++) {
            int j = i + 1;
            if (j == allList.size()) {
                break;
            }
            int a = allList.get(j) - allList.get(i);
            if (a > max) {
                max = a;
            }
        }
        return max;
    }
}
