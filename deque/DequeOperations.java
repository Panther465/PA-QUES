package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeOperations {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addLast(10);
        dq.addLast(20);
        dq.addFirst(5);
        dq.addFirst(1);
        System.out.println("Deque: " + dq);

        System.out.println("Front element: " + dq.peekFirst());
        System.out.println("Rear element: " + dq.peekLast());

        System.out.println("Removed from front: " + dq.pollFirst());
        System.out.println("Removed from rear: " + dq.pollLast());
        System.out.println("Deque now: " + dq);

        System.out.println("Size: " + dq.size());
        System.out.println("Is empty? " + dq.isEmpty());

        dq.clear();
        System.out.println("After clear, is empty? " + dq.isEmpty());
    }
}
