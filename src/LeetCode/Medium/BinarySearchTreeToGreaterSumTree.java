package LeetCode.Medium;

import LeetCode.TreeNode;

import static LeetCode.Tools.printArray;
import static LeetCode.Tools.printLevelOrder;

public class BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);
        root1.left.right.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        root1.right.right.right = new TreeNode(8);

        bstToGst(root1);
        printLevelOrder(root1);

        TreeNode root2 = new TreeNode(0);
        root2.left = null;
        root2.right = new TreeNode(1);

        bstToGst(root2);
        printLevelOrder(root2);
    }

    static int sum;
    public static TreeNode bstToGst(TreeNode root) {
        sum = 0;
        return bstToGstHelper(root);
    }

    // I solved this one by myself.
    private static TreeNode bstToGstHelper(TreeNode root) { // reverse-order = right, root, left
        if (root != null) {
            bstToGstHelper(root.right);
            sum += root.val;
            root.val = sum;
            bstToGstHelper(root.left);
        }
        return root;
    }

//    static List<Integer> values = new ArrayList<>();
//    public static int sumOfNodes(TreeNode root) {
//        putValuesIntoList(root);
//        printArray(values);
//        return 1;
//    }
//
//    // This is an in-order traversal so the list is ordered.
//    public static void putValuesIntoList(TreeNode root) {
//        if (root != null) {
//            putValuesIntoList(root.left);
//            values.add(root.val);
//            putValuesIntoList(root.right);
//        }
//    }
}