package LeetCode.Easy;

import LeetCode.TreeNode;

public class UnivaluedBinaryTree {
    public static void main(String[] args) {

    }

    public static boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    // I solved this problem by myself.
    public static boolean isUnivalTree(TreeNode root, int n) {
        if (root != null)
        {
            if (root.val != n)
                return false;
            if (!isUnivalTree(root.left, n) || !isUnivalTree(root.right, n))
                return false;
        }
        return true;
    }
}
