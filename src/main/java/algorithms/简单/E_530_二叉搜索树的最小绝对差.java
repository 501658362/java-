package algorithms.简单;

import algorithms.TreeNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/19
 */
public class E_530_二叉搜索树的最小绝对差 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rigt = new TreeNode(2);
        rigt.left = new TreeNode(3);
        root.right = rigt;

        E_530_二叉搜索树的最小绝对差 x = new E_530_二叉搜索树的最小绝对差();
        int integers = x.getMinimumDifference(root);
        System.out.println(integers);
    }
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inOrderTraverse2(root);
        return min;
    }

    public void inOrderTraverse2(TreeNode root) {
        if (root != null) {
            inOrderTraverse2(root.left);

            if (pre != null) {
                min = Math.min(min, Math.abs(pre.val - root.val));
            }
            pre = root;
            inOrderTraverse2(root.right);
        }
    }


}
