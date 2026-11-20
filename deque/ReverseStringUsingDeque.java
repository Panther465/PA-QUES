package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseStringUsingDeque {

    public static String reverse(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            dq.addFirst(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "hello world";
        System.out.println("Original: " + s);
        System.out.println("Reversed: " + reverse(s));
    }
}
