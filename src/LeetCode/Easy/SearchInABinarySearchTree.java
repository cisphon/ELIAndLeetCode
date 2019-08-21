package LeetCode.Easy;

import LeetCode.TreeNode;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);

        treeNode = searchBST(treeNode, 2);

        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val + " " + treeNode.right.val);
    }

    // concise recursive method.
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        else
            return val < root.val ? searchBST(root.left, val): searchBST(root.right,val);
    }

    public static TreeNode iterativeSolution(TreeNode root, int val) {
        while(root != null && root.val != val)
        {
            root = val < root.val? root.left: root.right;
        }
        return root;
    }
}
