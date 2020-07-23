package algorithms.简单;

import java.util.Random;

public class 国王收彩礼 {
    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

    public static void main(String[] args) {
        permutation("abc");
        String[] str = {"a", "b", "c"};
        int length = str.length;                                  //元素个数。
        //求出位图全组合的结果个数：2^n
        int nbit = 1 << length;                                     // “<<” 表示 左移:各二进位全部左移若干位，高位丢弃，低位补0。:即求出2^n=2Bit。
        System.out.println("全组合结果个数为：" + nbit);

        for (int i = 0; i < nbit; i++) {                        //结果有nbit个。输出结果从数字小到大输出：即输出0,1,2,3,....2^n。
            System.out.print("组合数值  " + i + " 对应编码为： ");
            for (int j = 0; j < length; j++) {                        //每个数二进制最多可以左移n次，即遍历完所有可能的变化新二进制数值了
                int tmp = 1 << j;
                if ((tmp & i) != 0) {                            //& 表示与。两个位都为1时，结果才为1
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }


        国王收彩礼 solution = new 国王收彩礼();
        int n = 2;
        // 组合总数

        int[][] fumaArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] a = new int[n];
            System.out.print("王子：" + (i + 1) + " 出彩礼：");
            for (int i1 = 0; i1 < n; i1++) {
                a[i1] = new Random().nextInt(100);
                System.out.print("公主" + (i1 + 1) + " " + a[i1] + " ");
            }
            System.out.println();
            fumaArray[i] = a;
        }
        findKth(fumaArray);
        System.out.println(1);
    }

    public static void findKth(int[][] fumaArray) {
        int[][] result = new int[1 << fumaArray.length][];
        int[] num = new int[fumaArray.length];
        for (int i = 0; i < fumaArray.length; i++) {
            num[i] = i;
        }

        int total = 1 << fumaArray.length;
        int[][] all = new int[total][];

        for (int j = 0; j < fumaArray.length; j++) {
            int[] a = new int[fumaArray[j].length];
            for (int z = 0; z < fumaArray[j].length; z++) {
                a[z] = fumaArray[j][z];
            }
            all[j] = a;
        }
        for (int i = 0; i < fumaArray.length; i++) {
            for (int j = 0; j < fumaArray.length; j++) {
//                fumaArray[i] +
            }
        }
        int[][] fuma = new int[3][];


    }

    private void doit(int[][] result, int[] num) {

        for (int j = 0; j < result.length; j++) {
            int[] a = new int[num.length];
            for (int i = 0; i < num.length; i++) {
                a[i] = num[i];

            }
            result[j] = a;
        }
    }

    private void getArray() {

    }
}
