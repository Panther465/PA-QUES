package queueassessment;

import java.util.ArrayDeque;
import java.util.Deque;

// Check palindrome using a deque. Ignore case, spaces and punctuation.
public class Q4_DequePalindromeChecker {

    static boolean isPalindrome(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                dq.addLast(Character.toLowerCase(ch));
            }
        }

        while (dq.size() > 1) {
            char first = dq.pollFirst();
            char last = dq.pollLast();
            if (first != last) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] tests = {
            "A man, a plan, a canal: Panama",
            "race a car",
            "Was it a car or a cat I saw?",
            "Madam",
            ""
        };
        for (String t : tests) {
            System.out.println("\"" + t + "\" -> " + isPalindrome(t));
        }
    }
}
