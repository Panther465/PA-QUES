package queueassessment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q6_SlidingWindowMaxDeque {

    static List<Integer> windowMax(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);

            if (i >= k - 1) {
                res.add(arr[dq.peekFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 12, 11, -5, 7, 3, 9};
        int k = 3;
        List<Integer> res = windowMax(arr, k);
        for (int i = 0; i < res.size(); i++) {
            System.out.println("Window [" + i + ".." + (i + k - 1) + "] max = " + res.get(i));
        }
    }
}
