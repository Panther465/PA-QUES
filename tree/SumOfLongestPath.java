package tree;

public class SumOfLongestPath {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    static int maxLen = 0;
    static int maxSum = 0;

    static void solve(Node root, int len, int sum) {
        if (root == null) return;

        len++;
        sum += root.data;

        if (root.left == null && root.right == null) {
            if (len > maxLen) {
                maxLen = len;
                maxSum = sum;
            } else if (len == maxLen && sum > maxSum) {
                maxSum = sum;
            }
            return;
        }

        solve(root.left, len, sum);
        solve(root.right, len, sum);
    }

    static int sumOfLongRootToLeafPath(Node root) {
        maxLen = 0;
        maxSum = 0;
        solve(root, 0, 0);
        return maxSum;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
        root.left.right.left = new Node(6);

        System.out.println("Sum: " + sumOfLongRootToLeafPath(root));
    }
}
