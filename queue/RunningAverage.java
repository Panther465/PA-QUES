package queue;

import java.util.LinkedList;
import java.util.Queue;

public class RunningAverage {

    // average of every window of size k
    public static void runningAverage(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        double sum = 0;

        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            sum += nums[i];

            if (q.size() > k) {
                sum -= q.poll();
            }

            if (q.size() == k) {
                System.out.println("Window ending at index " + i + " -> " + (sum / k));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        runningAverage(nums, k);
    }
}
