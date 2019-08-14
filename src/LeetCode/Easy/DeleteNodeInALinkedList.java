package LeetCode.Easy;

import static LeetCode.Tools.printListNode;

public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);

        deleteNode(listNode.next);
        printListNode(listNode);
    }

    public static void deleteNode(ListNode node) {
        if (node.next == null)
            return;

        ListNode curr = node;
        ListNode prev = null;
        while (curr.next != null)
        {
            curr.val = curr.next.val;
            prev = curr; // I was missing this
            curr = curr.next;
        }
        prev.next = null; // i was missing this
    }
}