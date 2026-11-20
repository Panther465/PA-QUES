package priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        minPq.add(40);
        minPq.add(10);
        minPq.add(30);
        minPq.add(20);
        System.out.println("Min PQ peek: " + minPq.peek());
        System.out.print("Min PQ order: ");
        while (!minPq.isEmpty()) {
            System.out.print(minPq.poll() + " ");
        }
        System.out.println();

        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        maxPq.add(40);
        maxPq.add(10);
        maxPq.add(30);
        maxPq.add(20);
        System.out.println("Max PQ peek: " + maxPq.peek());
        System.out.print("Max PQ order: ");
        while (!maxPq.isEmpty()) {
            System.out.print(maxPq.poll() + " ");
        }
        System.out.println();

        PriorityQueue<String> words = new PriorityQueue<>((a, b) -> a.length() - b.length());
        words.add("banana");
        words.add("kiwi");
        words.add("apple");
        words.add("fig");
        System.out.print("Words by length: ");
        while (!words.isEmpty()) {
            System.out.print(words.poll() + " ");
        }
        System.out.println();
    }
}
