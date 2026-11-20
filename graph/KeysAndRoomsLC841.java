package graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KeysAndRoomsLC841 {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        visited[0] = true;
        int count = 1;

        while (!st.isEmpty()) {
            int room = st.pop();
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    count++;
                    st.push(key);
                }
            }
        }
        return count == n;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms1 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            Arrays.asList()
        );
        System.out.println(canVisitAllRooms(rooms1));

        List<List<Integer>> rooms2 = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(3, 0, 1),
            Arrays.asList(2),
            Arrays.asList(0)
        );
        System.out.println(canVisitAllRooms(rooms2));
    }
}
