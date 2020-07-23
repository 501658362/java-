package algorithms.中级;

import java.util.List;

public class 两数相加2 {


    public static void main(String[] args) {

        Solution d = new Solution();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(5);
        n2.next.next = new ListNode(2);
        ListNode listNode = d.addTwoNumbers(n1, n2);
        System.out.println(1);


    }

    static class Solution {
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
            String num1 = "";
            String num2 = "";
            if (l1 != null) {
                num1 += getNum(num1, l1);
            }
            if (l2 != null) {
                num2 += getNum(num2, l2);
            }
            String newN1 = new StringBuffer(num1).reverse().toString();
            String newN2 = new StringBuffer(num2).reverse().toString();
            Long result = Long.parseLong(newN1) + Long.parseLong(newN2);
            String resultString = new StringBuffer(result.toString()).reverse().toString();
            ListNode r = null;
            ListNode t = null;
            for (char c : resultString.toCharArray()) {
                ListNode listNode = new ListNode(Integer.parseInt(String.valueOf(c)));
                if (r == null) {
                    r = listNode;
                    continue;
                }
                if (t == null) {
                    t = listNode;
                    r.next = t;
                    continue;
                }
                t.next = listNode;
                t = listNode;

            }

            return r;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode result = new ListNode(0);
            ListNode current = result;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
                int data = sum % 10;
                if (sum >= 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                current.next = new ListNode(data);
                current = current.next;

                if (l1 != null) {
                    l1 = l1.next;
                }

                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry == 1) {
                current.next = new ListNode(1);
            }

            // 1, 3, 4
            // 4  342+65
            // 2 4 3
            // 5 6
            return result.next;

        }

        private void getNum(List<Integer> list, ListNode l1) {
            if (l1 != null) {
                list.add(l1.val);
                getNum(list, l1.next);
            }
        }

        private String getNum(String num, ListNode l1) {
            if (l1 != null) {
                num += l1.val;
            } else {
                return num;
            }

            return getNum(num, l1.next);
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
