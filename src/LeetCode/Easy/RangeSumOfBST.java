package LeetCode.Easy;

public class RangeSumOfBST {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);

        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);

        treeNode.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(treeNode, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int L, int R) { // tree pruning
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (L <= root.val && root.val <= R) {
            sum += rangeSumBST(root.left, L, R);
            sum += root.val;
            sum += rangeSumBST(root.right, L, R);
        } else if (root.val < L) {
            sum += rangeSumBST(root.right, L, R);
        } else { // root.val > R
            sum += rangeSumBST(root.left, L, R);
        }

        return sum;
    }
}