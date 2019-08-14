package LeetCode.Easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        listNode = reverseList(listNode);

        printListNode(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        // curr.next, prev, curr, nextTemp (c.n, p, c, nT)
        while (curr != null) { //(Current News, Previous, Current, nextTemporary)
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    public static void printListNode(ListNode head) {
        ListNode curr = head;

        while (curr != null)
        {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
