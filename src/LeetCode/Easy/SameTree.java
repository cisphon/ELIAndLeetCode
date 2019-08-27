package LeetCode.Easy;

import LeetCode.TreeNode;

public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.left = null;
        q.right = new TreeNode(2);

        System.out.println(isSameTree(p, q));
    }

    // traverse and check if the values are the same.
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val)
                return false;
            if (!isSameTree(p.left, q.left))
                return false;
            if (!isSameTree(p.right, q.right))
                return false;
        }
        else if (p != null && q == null)
            return false;
        else if (p == null && q != null)
            return false;

        return true;
    }
}
