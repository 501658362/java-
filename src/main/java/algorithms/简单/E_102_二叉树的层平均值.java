package algorithms.简单;

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
public class E_102_二叉树的层平均值 {


    public static void main(String[] args) {
        E_102_二叉树的层平均值 x = new E_102_二叉树的层平均值();
        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        List<Double> lists = x.averageOfLevels(root);
        System.out.println(lists);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }


}

