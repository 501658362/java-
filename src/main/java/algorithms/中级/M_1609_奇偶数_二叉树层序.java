package algorithms.中级;

import algorithms.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/21
 */
public class M_1609_奇偶数_二叉树层序 {


    public static void main(String[] args) {
        M_1609_奇偶数_二叉树层序 x = new M_1609_奇偶数_二叉树层序();
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(10);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(7);
        right.left.left = new TreeNode(6);
        right.right = new TreeNode(9);
        right.right.right = new TreeNode(2);

        left.left = new TreeNode(3);
        left.left.left = new TreeNode(12);
        left.left.right = new TreeNode(8);
        boolean lists = x.isEvenOddTree(root);
        System.out.println(lists);
    }

    public boolean isEvenOddTree(TreeNode root) {

        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int p;
            if (count % 2 == 0) {
                // 偶数 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
                p = Integer.MIN_VALUE;
            } else {
                // 奇数 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
                p = Integer.MAX_VALUE;
            }

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (count % 2 == 0) {
                    if (poll.val % 2 != 0 && poll.val > p) {
                        p = poll.val;
                    } else {
                        return false;
                    }
                }
                if (count % 2 != 0) {
                    if (poll.val % 2 == 0 && poll.val < p) {
                        p = poll.val;
                    } else {
                        return false;
                    }
                }

                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            count++;
        }
        return true;
    }

}

