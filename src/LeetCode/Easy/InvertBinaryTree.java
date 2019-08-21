package LeetCode.Easy;

import LeetCode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);

        treeNode = invertTreeBFS(treeNode);

        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val + " " + treeNode.right.val);
    }

    // iterative DFS (DFS uses Stack) -- backtracking. 1 child pointer
    public static TreeNode invertTreeDFS(TreeNode root) {
        if (root == null)
            return null;

        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            final TreeNode node = stack.pop();
            swap(node);

            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        return root;
    }

    // iterative BFS (BFS uses Queue). -- no backtracking. k child pointers
    public static TreeNode invertTreeBFS(TreeNode root) {
        if (root == null)
            return null;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            final TreeNode node = queue.poll();
            swap(node);

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return root;
    }

    public static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // this is recursive DFS. this isn't scalable. it has potential for recursive stack overflow.
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        if (!(root.left == null && root.right == null)) {
            swap(root);
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
        }
        return root; // temp
    }
}