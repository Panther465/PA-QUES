package heap;

import java.util.PriorityQueue;

public class KthSmallestInMatrixLC378 {

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int r = 0; r < n; r++) {
            pq.add(new int[]{matrix[r][0], r, 0});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] curr = pq.poll();
            int r = curr[1];
            int c = curr[2];
            if (c + 1 < n) {
                pq.add(new int[]{matrix[r][c + 1], r, c + 1});
            }
        }
        return pq.peek()[0];
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 8));
        System.out.println(kthSmallest(new int[][]{{-5}}, 1));
    }
}
