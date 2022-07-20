package algorithms.简单;

import algorithms.TreeNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/19
 */
public class E_100_相同的树 {


    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rigt = new TreeNode(2);
        rigt.left = new TreeNode(3);
        root.right = rigt;
        TreeNode root2 = new TreeNode(1);
        TreeNode rigt2 = new TreeNode(2);
        rigt2.left = new TreeNode(3);
        root2.right = rigt2;

        E_100_相同的树 x = new E_100_相同的树();
        boolean integers = x.isSameTree(root, root2);
        System.out.println(integers);
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {


        if (root1 == null && root2 != null) {
            return false;
        }
        if (root2 == null && root1 != null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }

        if (!isSameTree(root1.left, root2.left)) {
            return false;
        }

        return isSameTree(root1.right, root2.right);
    }

}
