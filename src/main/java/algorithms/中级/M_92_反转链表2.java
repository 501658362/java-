package algorithms.中级;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2021/6/1
 */
public class M_92_反转链表2 {


    static ListNode t = null;

    public static void main(String[] args) {
//        int search = search(new int[]{1, 2, 3, 4}, 3);
//        System.out.println(search);

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        System.out.println(l1.toString());
//        ListNode re = reverseN(l1, 3);
        ListNode re = reverseBetween(l1, 2, 4);
        System.out.println(re.toString());
    }

    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static ListNode reverseWhile(ListNode head) {
        ListNode cur = head, pre = null, next = null;
        while (cur != null) {
            if (cur.next == null) {
                return cur;
            }
            next = cur.next.next;
            cur.next.next = cur;
            cur.next = pre;
            pre = cur;
        }
        return cur;
    }

    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            t = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = t;
        return last;
    }

    static ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
