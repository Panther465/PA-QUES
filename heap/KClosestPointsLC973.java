package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsLC973 {

    static int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public static int[][] kClosest(int[][] points, int k) {
        // max heap on distance, remove farthest when size goes above k
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> dist(b) - dist(a));
        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        System.out.println(Arrays.deepToString(kClosest(points, 1)));

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        System.out.println(Arrays.deepToString(kClosest(points2, 2)));
    }
}
