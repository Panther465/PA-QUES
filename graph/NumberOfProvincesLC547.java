package graph;

public class NumberOfProvincesLC547 {

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    static void dfs(int[][] graph, boolean[] visited, int u) {
        visited[u] = true;
        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] == 1 && !visited[v]) {
                dfs(graph, visited, v);
            }
        }
    }

    public static void main(String[] args) {
        int[][] g1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(g1));
        int[][] g2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(g2));
    }
}
