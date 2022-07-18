package algorithms.困难;

import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/18
 */
public class H_23_合并K个升序链表 {

    public static void main(String[] args) {
        H_23_合并K个升序链表 solution = new H_23_合并K个升序链表();
        ListNode x1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode x2 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode x3 = null;
        ListNode x4 = new ListNode(1);
        ListNode[] lists = new ListNode[] {x3, x4};
        ListNode iii = solution.mergeKLists(lists);
        System.out.println(1);

        PriorityQueue<Integer> x = new PriorityQueue<>();
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode temp = result;

        ListNode current = new ListNode();

        int size = lists.length;

        while (current != null) {
            Integer minI = null;
            Integer minVal = null;
            int nullNum = 0;
            for (int i = 0; i < size; i++) {
                if (lists[i] == null) {
                    nullNum++;
                    continue;
                }
                if (minI == null) {
                    minI = i;
                }
                if (minVal == null) {
                    minVal = lists[i].val;
                }
                if (lists[i].val < minVal) {
                    minVal = lists[i].val;
                    minI = i;
                }
            }
            if (nullNum == size) {
                current = null;
            }
            if (minVal != null) {
                temp.next = new ListNode(minVal);
                temp = temp.next;

                if (lists[minI] != null) {
                    lists[minI] = lists[minI].next;
                }
            }
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
