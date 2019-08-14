package LeetCode.Easy;

import java.util.List;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);

        ListNode merged = mergeTwoLists(l1, l2);

        printListNode(merged);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeTwoLists(l1, l2, null);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2, ListNode merged) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head = new ListNode(0); // this is just an arbitrary starting ListNode. it will be ignored later.
        ListNode curr = head;
        while(l1 != null && l2 != null) // an iterative approach to create the merged list
        {
            if (l1.val <= l2.val) {
                curr.next = l1; // the value l1 is pointing to is the next node in order.
                l1 = l1.next; // l1 points to l1.next
            }
            else {
                curr.next = l2;
                l2 = l2.next; // l2 points to l2.next
            }
            curr = curr.next; // curr points to curr.next
        }
        if (l1 != null) // this is for the remaining elements.
            curr.next = l1;
        else if(l2 != null) // this is for the remaining elements
            curr.next = l2;

        return head.next; // this returns everything after the head.
    }

    public static void printListNode(ListNode listNode) {
        ListNode curr = listNode;

        while (curr != null)
        {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}