package LeetCode.Easy;

import LeetCode.TreeNode;

public class ConvertBSTToGreaterTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);

        root = convertBST(root);

        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
    }

    public static TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }
    public static int dfs(TreeNode root, int val) {
        if(root == null) return val;
        int right = dfs(root.right, val);
        int left = dfs(root.left, root.val + right);
        root.val = root.val + right;
        return left;
    }
}
