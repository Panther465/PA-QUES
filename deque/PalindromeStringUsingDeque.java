package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeStringUsingDeque {

    public static boolean isPalindrome(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            dq.addLast(ch);
        }

        while (dq.size() > 1) {
            char first = dq.pollFirst();
            char last = dq.pollLast();
            if (first != last) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("madam -> " + isPalindrome("madam"));
        System.out.println("racecar -> " + isPalindrome("racecar"));
        System.out.println("hello -> " + isPalindrome("hello"));
    }
}
