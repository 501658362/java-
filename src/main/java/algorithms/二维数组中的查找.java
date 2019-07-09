package algorithms;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2019/7/9
 */
public class 二维数组中的查找 {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        int [][] array = new int[3][3];
        System.out.println(s.find(1, array));
    }

    static class Solution {
        public boolean find(int target, int [][] array) {
            int length = array.length;
            int length1 = array[0].length;
            int l = length/2;
            for (int[] ints : array) {
                for (int anInt : ints) {
                    if(anInt == target){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
