package LeetCode.Easy;

import LeetCode.TreeNode;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(2);
        treeNode1.left.left = new TreeNode(5);

        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(3);
        treeNode2.left.right = new TreeNode(4);
        treeNode2.right.right = new TreeNode(7);

        TreeNode merged = mergeTrees(treeNode1, treeNode2);
        System.out.println(merged.val + " ");
        System.out.print(merged.left.val + " ");
        System.out.println(merged.right.val + " ");
        System.out.print(merged.left.left.val + " ");
        System.out.print(merged.left.right.val + " ");
        System.out.print(merged.right.right.val + " ");
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}