package queue;

import java.util.LinkedList;
import java.util.Queue;

public class TimeToBuyTicketsLC2073 {

    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            q.add(i);
        }

        int time = 0;
        while (true) {
            int i = q.poll();
            tickets[i]--;
            time++;

            if (tickets[i] == 0) {
                if (i == k) return time;
            } else {
                q.add(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
    }
}
