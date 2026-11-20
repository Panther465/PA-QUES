package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StudentsUnableToEatLunchLC1700 {

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for (int s : students) {
            q.add(s);
        }

        int top = 0;
        int rotations = 0;
        // if everyone in queue has gone around once without eating, stop
        while (!q.isEmpty() && rotations < q.size()) {
            if (q.peek() == sandwiches[top]) {
                q.poll();
                top++;
                rotations = 0;
            } else {
                q.add(q.poll());
                rotations++;
            }
        }
        return q.size();
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}
