package algorithms.简单;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/19
 */
public class E_145_二叉树的后序遍历 {


    public static void main(String[] args) {
        E_145_二叉树的后序遍历 x = new E_145_二叉树的后序遍历();
        TreeNode left = new TreeNode(1);
        TreeNode left2 = new TreeNode(1);
        TreeNode rigt2 = new TreeNode(2);
        TreeNode rigt = new TreeNode(2, left2, rigt2);

        TreeNode root = new TreeNode(5, left, rigt);

        List<Integer> integers = x.postorderTraversal(root);

        System.out.println(integers);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        getLeft(root, result);

        return result;
    }


    private void getLeft(TreeNode node, List<Integer> result) {
        if (node.left != null) {
            getLeft(node.left, result);
        }
        if (node.right != null) {
            getLeft(node.right, result);
        }
        result.add(node.val);
    }


    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
