package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsLC950 {

    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        int[] ans = new int[n];
        for (int card : deck) {
            ans[q.poll()] = card;
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }
}
