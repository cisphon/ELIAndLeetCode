package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class NaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> preorder(Node root) {
        if (root == null)
            return list;

        list.add(root.val);
        for(Node node: root.children)
            preorder(node);

        return list;
    }

    public List<Integer> iterativeSolution(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }
}
