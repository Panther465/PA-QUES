package tree;

public class BinaryTreeValidation {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    static boolean isValid(Node root, long min, long max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return isValid(root.left, min, root.data) && isValid(root.right, root.data, max);
    }

    static boolean isValidBST(Node root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(10);
        System.out.println("Tree 1 valid BST: " + isValidBST(root));

        Node root2 = new Node(8);
        root2.left = new Node(4);
        root2.right = new Node(12);
        root2.right.left = new Node(7);
        System.out.println("Tree 2 valid BST: " + isValidBST(root2));
    }
}
