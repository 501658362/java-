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
public class M_剑指_144_二叉树的每层最大值 {


    public static void main(String[] args) {
        M_剑指_144_二叉树的每层最大值 x = new M_剑指_144_二叉树的每层最大值();
        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        List<Integer> lists = x.largestValues(root);
        System.out.println(lists);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int x = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                x = Math.max(poll.val, x);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(x);
        }
        return result;
    }

}

