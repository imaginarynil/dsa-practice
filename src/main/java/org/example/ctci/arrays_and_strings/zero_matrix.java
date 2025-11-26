package org.example.ctci.arrays_and_strings;

public class zero_matrix {
    void printMatrix(int[][] input, int rowCount, int colCount) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.printf("%d ", input[i][j]);
            }
            System.out.println();
        }
    }

    void solve(int[][] input, int rowCount, int colCount) {
        int[][] result = new int[rowCount][colCount];
        // copy
        for (int i = 0; i < rowCount; i++) {
            System.arraycopy(input[i], 0, result[i], 0, colCount);
        }
        // set row and col of an element "0" with zeros
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (input[i][j] == 0) {
                    for (int k = 0; k < rowCount; k++) {
                        result[k][j] = 0;
                    }
                    for (int k = 0; k < colCount; k++) {
                        result[i][k] = 0;
                    }
                }
            }
        }
        printMatrix(result, rowCount, colCount);
    }

    void nullifyRow(int[][] input, int row, int colCount) {
        for (int i = 0; i < colCount; i++) {
            input[row][i] = 0;
        }
    }

    void nullifyCol(int[][] input, int col, int rowCount) {
        for (int i = 0; i < rowCount; i++) {
            input[i][col] = 0;
        }
    }

    void zeroMatrix_Solution(int[][] input, int rowCount, int colCount) {
        boolean[] rowFlag = new boolean[rowCount];
        boolean[] colFlag = new boolean[colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (input[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        for (int i = 0; i < rowFlag.length; i++) {
            if (rowFlag[i]) {
                nullifyRow(input, i, colCount);
            }
        }

        for (int i = 0; i < colFlag.length; i++) {
            if (colFlag[i]) {
                nullifyCol(input, i, rowCount);
            }
        }
    }

    void main() {
        int[][] input = {
                {0, 2, 3, 4, 5, 6},
                {1, 2, 0, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 0, 6},
                {1, 2, 3, 4, 5, 6},
        };
        printMatrix(input, input.length, input[0].length);
        System.out.println();
        zeroMatrix_Solution(input, input.length, input[0].length);
        printMatrix(input, input.length, input[0].length);
    }
}
