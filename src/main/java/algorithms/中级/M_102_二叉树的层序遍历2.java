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
public class M_102_二叉树的层序遍历2 {


    public static void main(String[] args) {
        M_102_二叉树的层序遍历2 x = new M_102_二叉树的层序遍历2();
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
        LinkedList<List<Integer>> result = new LinkedList<>();

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

            result.addFirst(c);


        }
        return result;
    }

}

