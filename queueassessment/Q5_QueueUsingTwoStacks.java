package queueassessment;

import java.util.Stack;

public class Q5_QueueUsingTwoStacks {
    static class MyQueue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void enqueue(int x) {
            s1.push(x);
        }

        void shift() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }

        int dequeue() {
            shift();
            if (s2.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s2.pop();
        }

        int peek() {
            shift();
            if (s2.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s2.peek();
        }

        boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        int size() {
            return s1.size() + s2.size();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("Front: " + q.peek());
        System.out.println("Dequeued: " + q.dequeue());

        q.enqueue(4);
        System.out.println("Size: " + q.size());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Is empty: " + q.isEmpty());
        q.dequeue();
    }
}
