package algorithms.简单;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/19
 */
public class E_144_二叉树的前序遍历 {


    public static void main(String[] args) {
        E_144_二叉树的前序遍历 x = new E_144_二叉树的前序遍历();
        //TreeNode left = new TreeNode(1);
        //TreeNode left2 = new TreeNode(1);
        //TreeNode rigt2 = new TreeNode(2);
        //TreeNode rigt = new TreeNode(2, left2, rigt2);
        //
        //TreeNode root = new TreeNode(5, left, rigt);
        //

        TreeNode root = new TreeNode(1);
        TreeNode rigt = new TreeNode(2);
        rigt.left = new TreeNode(3);
        root.right = rigt;
        List<Integer> integers = x.preorderTraversal(root);

        System.out.println(integers);
        List<Integer> integers2 = x.preorderTraversal2(root);

        System.out.println(integers2);
    }



    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        inOrderTraverse1(root, result);

        return result;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        inOrderTraverse2(root, result);

        return result;
    }

    public void inOrderTraverse1(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            inOrderTraverse1(root.left, result);
            inOrderTraverse1(root.right, result);
        }
    }


    private void inOrderTraverse2(TreeNode node, List<Integer> result) {
        result.add(node.val);
        if (node.left != null) {
            inOrderTraverse2(node.left, result);
        }
        if (node.right != null) {
            inOrderTraverse2(node.right, result);
        }
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
