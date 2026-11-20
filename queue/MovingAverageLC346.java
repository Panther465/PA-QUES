package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageLC346 {
    Queue<Integer> q;
    int size;
    double sum;

    public MovingAverageLC346(int size) {
        this.size = size;
        q = new LinkedList<>();
        sum = 0;
    }

    public double next(int val) {
        q.add(val);
        sum += val;
        if (q.size() > size) {
            sum -= q.poll();
        }
        return sum / q.size();
    }

    public static void main(String[] args) {
        MovingAverageLC346 m = new MovingAverageLC346(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}
