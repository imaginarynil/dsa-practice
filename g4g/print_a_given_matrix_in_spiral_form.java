package org.example.g4g;

import java.util.ArrayList;

/* TODO
 * https://www.geeksforgeeks.org/dsa/print-a-given-matrix-in-spiral-form/
 * */

public class print_a_given_matrix_in_spiral_form {
    void printAGivenMatrixInSpiralForm(int[][] mat, boolean[][] visited, ArrayList<Integer> path, int i, int j) {
        if (i == mat.length || j == mat[0].length || i < 0 || j < 0) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        path.add(mat[i][j]);
        printAGivenMatrixInSpiralForm(mat, visited, path, i, j + 1);
        printAGivenMatrixInSpiralForm(mat, visited, path, i + 1, j);
        printAGivenMatrixInSpiralForm(mat, visited, path, i, j - 1);
        printAGivenMatrixInSpiralForm(mat, visited, path, i - 1, j);
    }

    void printAGivenMatrixInSpiralForm_Solution_1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] vDir = {0, 1, 0, -1};
        int[] hDir = {1, 0, -1, 0};
        int dirIdx = 0;
        ArrayList<Integer> path = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (int x = 0; x < m * n; x++) {
            visited[i][j] = true;
            path.add(mat[i][j]);
            int newI = i + vDir[dirIdx];
            int newJ = j + hDir[dirIdx];
            if (newI < 0 || newI == m || newJ < 0 || newJ == n || visited[newI][newJ]) {
                dirIdx = (dirIdx + 1) % 4;
                i += vDir[dirIdx];
                j += hDir[dirIdx];
            } else {
                i = newI;
                j = newJ;
            }
        }
    }

    void main() {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        boolean[][] visited = new boolean[mat.length][mat[0].length];
//        ArrayList<Integer> path = new ArrayList<>();
//        printAGivenMatrixInSpiralForm(mat, visited, path, 0, 0);

        printAGivenMatrixInSpiralForm_Solution_1(mat);
    }
}
