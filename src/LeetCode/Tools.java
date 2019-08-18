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
