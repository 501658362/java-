package algorithms.简单;

import java.util.PriorityQueue;

public class E_21_合并两个有序链表2 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
     * <p>
     * <p>
     * <p>
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
     * ListNode next) { this.val = val; this.next = next; } }
     */


    public static void main(String[] args) {
        E_21_合并两个有序链表2 solution = new E_21_合并两个有序链表2();
        ListNode x1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode x2 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode iii = solution.mergeTwoLists(x1, x2);
        System.out.println(1);

        PriorityQueue<Integer> x = new PriorityQueue<>();
    }

    public ListNode mergeTwoLists(ListNode temp1, ListNode temp2) {
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        ListNode l1 = temp1, l2 = temp2;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                result.next = l2;
                l2 = l2.next;
            } else {
                result.next = l1;
                l1 = l1.next;
            }
            result = result.next;
        }

        if (l1 != null) {
            result.next = l1;
        }

        if (l2 != null) {
            result.next = l2;
        }

        return temp.next;
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
