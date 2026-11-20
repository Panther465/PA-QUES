package tree;

import java.util.Stack;

public class IterativePreorder {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    static void preorder(Node root) {
        if (root == null) return;

        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node curr = st.pop();
            System.out.print(curr.data + " ");
            // push right first so left is processed first
            if (curr.right != null) st.push(curr.right);
            if (curr.left != null) st.push(curr.left);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        preorder(root);
    }
}
