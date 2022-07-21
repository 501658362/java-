package algorithms.中级;

import algorithms.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/21
 */
public class M_102_二叉树的层序遍历 {


    public static void main(String[] args) {
        M_102_二叉树的层序遍历 x = new M_102_二叉树的层序遍历();
        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        List<List<Integer>> lists = x.levelOrder(root);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> c = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                c.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }

            result.add(c);


        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        List<Integer> f = new ArrayList<>();
        f.add(root.val);
        result.add(f);
        List<TreeNode> rest2 = new ArrayList<>();
        rest2.add(root.left);
        rest2.add(root.right);

        inOrderTraverse1(rest2, result);
        return result;
    }

    public void inOrderTraverse1(List<TreeNode> rest, List<List<Integer>> result) {
        List<Integer> c = new ArrayList<>();
        List<TreeNode> rest2 = new ArrayList<>();
        for (TreeNode treeNode : rest) {
            if (treeNode == null) {
                continue;
            }
            c.add(treeNode.val);
            rest2.add(treeNode.left);
            rest2.add(treeNode.right);
        }
        if (c.size() > 0) {
            result.add(c);
        }
        if (rest2.size() > 0) {
            inOrderTraverse1(rest2, result);
        }
    }

}

