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
public class M_1161_最大层内元素和 {


    public static void main(String[] args) {
        M_1161_最大层内元素和 x = new M_1161_最大层内元素和();
        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        int r = x.maxLevelSum(root);
        System.out.println(r);
    }

    public int maxLevelSum(TreeNode root) {
        int r = Integer.MIN_VALUE;

        if (root == null) {
            return r;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            level++;
            int sum = 0;
            int size = queue.size();
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
            if (sum > r) {
                r = sum;
                result = level;
            }
        }
        return result;
    }

}

