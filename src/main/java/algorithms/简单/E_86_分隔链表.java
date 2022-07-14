package algorithms.简单;


/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng Date: 2022/7/14
 */
public class E_86_分隔链表 {

    public static void main(String[] args) {
        E_86_分隔链表 solution = new E_86_分隔链表();
        // 1,4,3,2,5,2
        ListNode x1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode x2 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode iii = solution.partition(x1, 3);
        System.out.println(1);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode result = new ListNode(0);
        ListNode resultC = result;

        ListNode bigger = new ListNode(0);
        ListNode biggerC = bigger;

        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                resultC.next = new ListNode(p.val);
                resultC = resultC.next;
            } else {
                biggerC.next = new ListNode(p.val);
                biggerC = biggerC.next;
            }

            p = p.next;
        }

        resultC.next = bigger.next;

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
