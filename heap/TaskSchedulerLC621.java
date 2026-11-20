package heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskSchedulerLC621 {

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) {
            if (f > 0) pq.add(f);
        }

        // {remaining count, time when it can run again}
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int cnt = pq.poll() - 1;
                if (cnt > 0) {
                    cooldown.add(new int[]{cnt, time + n});
                }
            }
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                pq.add(cooldown.poll()[0]);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
    }
}
