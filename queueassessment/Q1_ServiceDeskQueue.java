package queueassessment;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q1_ServiceDeskQueue {
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> waiting = new HashSet<>();
    Set<Integer> cancelled = new HashSet<>();
    int nextToken = 1;

    int join() {
        int token = nextToken++;
        q.add(token);
        waiting.add(token);
        return token;
    }

    boolean cancel(int token) {
        if (!waiting.contains(token)) return false;
        waiting.remove(token);
        cancelled.add(token);
        return true;
    }

    int serve() {
        while (!q.isEmpty() && cancelled.contains(q.peek())) {
            cancelled.remove(q.poll());
        }
        if (q.isEmpty()) return -1;

        int token = q.poll();
        waiting.remove(token);
        return token;
    }

    int waitingCount() {
        return waiting.size();
    }

    public static void main(String[] args) {
        Q1_ServiceDeskQueue desk = new Q1_ServiceDeskQueue();
        for (int i = 0; i < 5; i++) {
            System.out.println("Token " + desk.join() + " joined");
        }

        System.out.println("Cancel 2: " + desk.cancel(2));
        System.out.println("Cancel 4: " + desk.cancel(4));
        System.out.println("Cancel 9: " + desk.cancel(9));
        System.out.println("Waiting: " + desk.waitingCount());

        int t = desk.serve();
        while (t != -1) {
            System.out.println("Serving token " + t);
            t = desk.serve();
        }
        System.out.println("No one left in queue");
    }
}
