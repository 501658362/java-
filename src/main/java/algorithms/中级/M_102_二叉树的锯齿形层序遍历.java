package algorithms.中级;

import algorithms.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/21
 */
public class M_102_二叉树的锯齿形层序遍历 {


    public static void main(String[] args) {
        M_102_二叉树的锯齿形层序遍历 x = new M_102_二叉树的锯齿形层序遍历();
        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        List<List<Integer>> lists = x.zigzagLevelOrder(root);
        System.out.println(lists);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean count = false;

        while (!queue.isEmpty()) {
            LinkedList<Integer> c = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (count) {
                    c.addFirst(poll.val);
                } else {
                    c.addLast(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            count = !count;
            result.add(c);


        }
        return result;
    }

}

