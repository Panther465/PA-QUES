package queueassessment;

import java.util.PriorityQueue;

public class Q3_PriorityLabAccess {
    static class Request {
        String student;
        int priority;
        int time;

        Request(String student, int priority, int time) {
            this.student = student;
            this.priority = priority;
            this.time = time;
        }
    }

    static String label(int p) {
        if (p == 1) return "exam";
        if (p == 2) return "project";
        return "practice";
    }

    public static void main(String[] args) {
        PriorityQueue<Request> pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) return a.priority - b.priority;
            return a.time - b.time;
        });

        pq.add(new Request("Vikas", 3, 1));
        pq.add(new Request("Riya", 2, 2));
        pq.add(new Request("Mohit", 1, 3));
        pq.add(new Request("Sneha", 2, 4));
        pq.add(new Request("Arjun", 1, 5));
        pq.add(new Request("Pooja", 3, 6));

        int seats = 4;
        System.out.println("Lab seats: " + seats);
        while (!pq.isEmpty() && seats > 0) {
            Request r = pq.poll();
            System.out.println("Access given to " + r.student + " (" + label(r.priority) + ")");
            seats--;
        }

        System.out.println("Still waiting:");
        while (!pq.isEmpty()) {
            Request r = pq.poll();
            System.out.println(r.student + " (" + label(r.priority) + ")");
        }
    }
}
