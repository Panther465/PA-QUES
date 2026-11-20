package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    // in level order, once we see a null there should be no node after it
    static boolean isComplete(Node root) {
        if (root == null) return true;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean seenNull = false;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                seenNull = true;
            } else {
                if (seenNull) return false;
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        System.out.println("Tree 1 complete: " + isComplete(root));

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.right.right = new Node(5);
        System.out.println("Tree 2 complete: " + isComplete(root2));
    }
}
