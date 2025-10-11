package org.example.arrays_and_strings;

public class rotate_matrix {
    static int[][] solve(int[][] input, int row_count, int col_count) {
        int[][] res = new int[row_count][col_count];
        for (int i = 0; i < row_count; i++) {
            for (int j = 0; j < col_count; j++) {
                res[j][Math.abs(col_count - i - 1)] = input[i][j];
            }
        }
        return res;
    }

    static void book_solution(int[][] input, int rowCount, int colCount) {
        if(rowCount != colCount) return;
        int n = rowCount;
        // go to each layer
        /* check by excel. if odd, 1 cell center, else no center
        * 2 1
        * 3 1
        * 4 2
        * 5 2
        * 6 3
        * 7 3
        * */
        for(int layer = 0; layer < n / 2; layer++) {
            int start = layer;
            int end = n - 1 - layer;
            for(int i = start; i < end; i++) {
                int offset = i - start;
                int top = input[start][i];
                input[start][i] = input[end - offset][start]; // bl > tr
                input[end - offset][start] = input[end][end - offset]; // br > bl
                input[end][end - offset] = input[i][end]; // tr > br
                input[i][end] = top; // tl > tr
            }
        }
        return;
    }

    static void main() {
//        int[][] mat = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//        };
//        int n = 3;
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        int n = 4;
        book_solution(mat, n, n);
        for (int[] row : mat) {
            for (int el : row) {
                System.out.printf("%d ", el);
            }
            System.out.println();
        }
    }
}
