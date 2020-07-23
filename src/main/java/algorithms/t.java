package algorithms;

// 本题为考试多行输入输出规范示例，无需提交，不计分。


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class t {
    Map<Object, Object> o = new HashMap<>(1024);

    public static void main(String[] args) {
        t t1 = new t();
        while (true) {
            t1.o.put(System.currentTimeMillis() + UUID.randomUUID().toString(), System.currentTimeMillis());
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
            System.out.println(System.currentTimeMillis());
//                }
//            }).start();
        }
//        System.out.println("请输入一个数字");
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        System.out.println("输入了：" + n);
//        Map<String, String> map = new HashMap<>(n);
//        String[] data = new String[n];
//        for (int i = 0; i < n; i++) {
//            String[] input = getInput();
//            map.put(input[1], input[0]);
//            data[i] = input[1];
//        }
//        if (map.size() > 0) {
//            String result = "";
//            int top = 0;
//            for (String s : data) {
//                int time = 0;
//                boolean contain = true;
//                String key = s;
//                while (contain) {
//                    contain = contain(map, key);
//                    if (contain) {
//                        key = map.get(key);
//                        time++;
//                    }
//                }
//                if (time >= top) {
//                    result = s;
//                }
//            }
//
//            System.out.println(result);
//        }


    }


    public static boolean contain(Map<String, String> map, String key) {
        return map.containsKey(key);
    }

    public static String[] getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入两个字符串，用空格分割");
        String a = sc.nextLine();
        String[] s = a.split(" ");
        if (s.length != 2) {
            System.out.println("输入不合法");
            return getInput();
        }
        return s;
    }
}