package LeetCode;

import LeetCode.Easy.ListNode;

import java.util.List;

public class Tools {
    public static void printArray(int[] list) { // O(n) time
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[r].length; ++c) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[r].length; ++c) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // function to print level order traversal of tree
    public static void printLevelOrder(TreeNode root) {
        int h = height(root);
        for (int i = 1; i <= h; i++)
            printGivenLevel(root, i);
        System.out.println();
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;
        else
        {
            // compute  height of each subtree
            int lheight = height(root.left);
            int rheight = height(root.right);

            // use the larger one
            if (lheight > rheight)
                return(lheight + 1);
            else
                return(rheight + 1);
        }
    }

    // Print nodes at the given level
    private static void printGivenLevel(TreeNode root, int level) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        if (level == 1)
            System.out.print(root.val + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public static <E> void printArray(List<E> list) { // O(n) time
        for (E i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printListNode(ListNode curr) {
        if (curr != null) {
            System.out.print(curr.val + " ");
            printListNode(curr.next);
        }
    }

    public static String OCDPrintArray(int[] list) {
        String s = "{";
        for (int i : list) {
            s = s + i + ", ";
        }
        s = s.substring(0, s.length()-2);
        s += "}";

        return s;
    }
}
