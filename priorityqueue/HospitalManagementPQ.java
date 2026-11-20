package priorityqueue;

import java.util.PriorityQueue;

public class HospitalManagementPQ {
    static class Patient {
        String name;
        int severity;
        int arrival;

        Patient(String name, int severity, int arrival) {
            this.name = name;
            this.severity = severity;
            this.arrival = arrival;
        }
    }

    public static void main(String[] args) {
        // higher severity first, if same then whoever came first
        PriorityQueue<Patient> pq = new PriorityQueue<>((a, b) -> {
            if (a.severity != b.severity) return b.severity - a.severity;
            return a.arrival - b.arrival;
        });

        pq.add(new Patient("Rahul", 3, 1));
        pq.add(new Patient("Priya", 5, 2));
        pq.add(new Patient("Aman", 1, 3));
        pq.add(new Patient("Neha", 5, 4));
        pq.add(new Patient("Karan", 4, 5));

        System.out.println("Order of treatment:");
        while (!pq.isEmpty()) {
            Patient p = pq.poll();
            System.out.println(p.name + " (severity " + p.severity + ")");
        }
    }
}
