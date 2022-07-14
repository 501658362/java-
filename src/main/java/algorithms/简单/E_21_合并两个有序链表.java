package algorithms.简单;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class E_21_合并两个有序链表 {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <p>
     * <p>
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */


    public static void main(String[] args) {
        E_21_合并两个有序链表 solution = new E_21_合并两个有序链表();
//        int i = solution.romanToInt("IV");
        ListNode x1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode x2 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode iii = solution.mergeTwoLists(x1, x2);
        System.out.println(1);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> data = new ArrayList<>();
        getNum(data, l1);
        getNum(data, l2);
        data.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Iterator<Integer> iterator = data.iterator();
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (iterator.hasNext()) {
            temp.next = new ListNode(iterator.next());
            temp = temp.next;
        }

        return result.next;
    }

    private void getNum(List<Integer> data, ListNode l1) {
        ListNode temp = l1;
        while (temp != null) {
            data.add(temp.val);
            temp = temp.next;
        }
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
