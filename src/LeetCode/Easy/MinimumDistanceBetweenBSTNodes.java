package LeetCode.Easy;

import LeetCode.TreeNode;

import java.util.*;

/*

    In-order traversal is faster.
    The traversal goes through each node once in the tree and gives the order.

 */

public class MinimumDistanceBetweenBSTNodes {
    static ArrayList<Integer> values;
    public int minDiffInBST(TreeNode root) {
        values = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        recurse(root);

        for (int i = 0; i < values.size() - 1; i++) {
            int difference = values.get(i + 1) - values.get(i);
            if (difference < min) {
                min = difference;
                if (min == 1) {
                    return min;
                }
            }
        }

        return min;
    }

    static void recurse(TreeNode root) { // in-order traversal
        if (root == null) {
            return;
        }

        if (root.left != null) {
            recurse(root.left);
        }

        values.add(root.val);

        if (root.right != null) {
            recurse(root.right);
        }
    }
}

class Solution { // a really fast solution!
    Integer res = Integer.MAX_VALUE, pre = null;
    public int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }
}