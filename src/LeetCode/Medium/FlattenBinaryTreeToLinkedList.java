package LeetCode.Medium;

import LeetCode.TreeNode;
import com.sun.source.tree.Tree;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(6);

        flatten(treeNode);

        System.out.println(treeNode.val);
        System.out.println(treeNode.right.val);
        System.out.println(treeNode.right.right.val);
        System.out.println(treeNode.right.right.right.val);
        System.out.println(treeNode.right.right.right.right.val);
        System.out.println(treeNode.right.right.right.right.right.val);
    }

    public static void flatten(TreeNode root) {
        if (root == null)
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;

        TreeNode cur = root;
        while (cur.right != null)
            cur = cur.right;
        cur.right = right;
    }
}
