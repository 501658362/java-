package algorithms.困难;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/18
 */
public class H_23_合并K个升序链表_优先队列 {

    public static void main(String[] args) {
        H_23_合并K个升序链表_优先队列 solution = new H_23_合并K个升序链表_优先队列();
        ListNode x1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode x2 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode x3 = null;
        ListNode x4 = new ListNode(1);
        ListNode[] lists = new ListNode[] {x3, x4, x1};
        ListNode iii = solution.mergeKLists(lists);
        System.out.println(1);

        PriorityQueue<Integer> x = new PriorityQueue<>();
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            while (list != null) {
                priorityQueue.add(new ListNode(list.val));
                list = list.next;
            }

        }
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (true) {
            ListNode poll = priorityQueue.poll();
            if (poll == null) {
                break;
            }
            temp.next = poll;
            temp = temp.next;

        }

        return result.next;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
