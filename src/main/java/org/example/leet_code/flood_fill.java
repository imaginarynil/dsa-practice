package org.example.leet_code;

public class flood_fill {
    void _floodFill(int[][] image, boolean[][] visited, int sr, int sc, int rowCount, int colCount, int srcColor, int dstColor) {
        if (sr < 0 || sr >= rowCount || sc < 0 || sc >= colCount) {
            return;
        }
        if(image[sr][sc] != srcColor) {
            return;
        }
        if(visited[sr][sc]) {
            return;
        }
        image[sr][sc] = dstColor;
        visited[sr][sc] = true;
        _floodFill(image, visited, sr + 1, sc, rowCount, colCount, srcColor, dstColor);
        _floodFill(image, visited, sr - 1, sc, rowCount, colCount, srcColor, dstColor);
        _floodFill(image, visited, sr, sc + 1, rowCount, colCount, srcColor, dstColor);
        _floodFill(image, visited, sr, sc - 1, rowCount, colCount, srcColor, dstColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        if(image[sr][sc] == color) {
            return image;
        }
        _floodFill(image, visited, sr, sc, image.length, image[0].length, image[sr][sc], color);
        return image;
    }

    void main() {
        int[][] x;
        x = floodFill(new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1},}, 1, 1, 2);
    }
}
