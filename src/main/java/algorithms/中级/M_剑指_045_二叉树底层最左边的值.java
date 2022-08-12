package algorithms.中级;

import algorithms.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/21
 */
public class M_剑指_045_二叉树底层最左边的值 {


    public static void main(String[] args) {
        M_剑指_045_二叉树底层最左边的值 x = new M_剑指_045_二叉树底层最左边的值();
        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        int lists = x.findBottomLeftValue(root);
        System.out.println(lists);
    }

    public int findBottomLeftValue(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int r = 0;
        boolean flag = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (!flag) {
                    r = poll.val;
                    flag = true;
                }
                if (poll.left != null) {
                    queue.add(poll.left);

                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return r;
    }

}

