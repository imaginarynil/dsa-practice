package org.example.neetcode;

import java.util.HashSet;
import java.util.Set;

public class valid_sudoku {
    /*
     * n = board row count
     * m = board col count
     * O(n * m) */
    public boolean isValidSudoku_BruteForce(char[][] board) {
        Set<Character> set = new HashSet<>();
        final char BLANK_CHAR = '.';
        // check each row
        // O(n * m)
        for (int row = 0; row < board.length; row++) {
            for (int i = 0; i < board[0].length; i++) {
                char x = board[row][i];
                if (x != BLANK_CHAR) {
                    if (!set.contains(x)) {
                        set.add(x);
                    } else {
                        return false;
                    }
                }
            }
            set.clear();
        }
        // check each col
        // O(n * m)
        for (int col = 0; col < board[0].length; col++) {
            for (int i = 0; i < board.length; i++) {
                char x = board[i][col];
                if (x != BLANK_CHAR) {
                    if (!set.contains(x)) {
                        set.add(x);
                    } else {
                        return false;
                    }
                }
            }
            set.clear();
        }
        // check each grid
        // O(n * m), visit every element once
        int GRID_ROW_COUNT = 3;
        int GRID_COL_COUNT = 3;
        for (int rowOffset = 0; rowOffset < board.length; rowOffset += 3) {
            for (int colOffset = 0; colOffset < board[0].length; colOffset += 3) {
                for (int i = rowOffset; i < rowOffset + GRID_ROW_COUNT; i++) {
                    for (int j = colOffset; j < colOffset + GRID_COL_COUNT; j++) {
                        char x = board[i][j];
                        if (x != BLANK_CHAR) {
                            if (!set.contains(x)) {
                                set.add(x);
                            } else {
                                return false;
                            }
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }

    void main() {
//        char[][] in = {
//                {'1','2','.','.','3','.','.','.','.'},
//                {'4','.','.','5','.','.','.','.','.'},
//                {'.','9','8','.','.','.','.','.','3'},
//                {'5','.','.','.','6','.','.','.','4'},
//                {'.','.','.','8','.','3','.','.','5'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','.','.','.','.','.','2','.','.'},
//                {'.','.','.','4','1','9','.','.','8'},
//                {'.','.','.','.','8','.','.','7','9'}};
//        char[][] in = {
//                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
//                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
//                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
//                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
//                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] in = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        var x = isValidSudoku_BruteForce(in);
    }
}
