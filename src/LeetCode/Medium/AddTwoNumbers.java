package LeetCode.Medium;

import LeetCode.Easy.ListNode;


public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(3);

        ListNode added = addTwoNumbers(listNode1, listNode2);

        printListNode(added);
    }

    // O(2 * max(l1, l2)) => O(max(l1, l2))
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int sum) {
        if (sum == 0 && l1 == null) {
            return l2;
        }
        if (sum == 0 && l2 == null) {
            return l1;
        }
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }
        ListNode res = new ListNode(sum % 10);
        res.next = addTwoNumbers(l1, l2, sum / 10);
        return res;
    }

    public static void printListNode(ListNode listNode) {
        ListNode curr = listNode;

        while (curr != null)
        {
            System.out.print(curr.val);
            curr = curr.next;
        }
    }
}


class Solution2 {
    // space and time: O(max(m,n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;

        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}