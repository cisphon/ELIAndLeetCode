package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static LeetCode.Tools.printListNode;

public class MiddleOfTheLinkedList
{

    public static void main(String[] args)
    {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        listNode = middleNode(listNode);
        printListNode(listNode);
    }

    public static void ass(ListNode head)
    {
        ListNode temp = head;
        temp.val = -1;
    }

    public static ListNode middleNode(ListNode head) // O(n) time complexity, O(n) space complexity
    {
        Map<Integer, ListNode> indexListPair = new HashMap<>();

        int index = 0;
        while (head != null)
        {
            indexListPair.put(index++, head);
            head = head.next;
        }

        return indexListPair.get(index / 2);
    }

    public static ListNode anotherSolution(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}