package queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeightLC1046 {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            pq.add(s);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (y != x) {
                pq.add(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeight(new int[]{1}));
    }
}
