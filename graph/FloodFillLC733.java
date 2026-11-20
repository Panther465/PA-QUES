package graph;

import java.util.Arrays;

public class FloodFillLC733 {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
        if (old == color) return image;
        dfs(image, sr, sc, old, color);
        return image;
    }

    static void dfs(int[][] image, int r, int c, int old, int color) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;
        if (image[r][c] != old) return;

        image[r][c] = color;
        dfs(image, r + 1, c, old, color);
        dfs(image, r - 1, c, old, color);
        dfs(image, r, c + 1, old, color);
        dfs(image, r, c - 1, old, color);
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 2)));
    }
}
