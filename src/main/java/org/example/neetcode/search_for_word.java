package org.example.neetcode;

public class search_for_word {
    public boolean visited[][];

    public boolean isInBoard(boolean[][] visited, int i, int j, int rowCount, int colCount) {
        return i >= 0 && i < rowCount && j >= 0 && j < colCount && !visited[i][j];
    }

    public boolean search(char[][] board, boolean[][] visited, String word, int i, int j, int wordIdx) {
        if (wordIdx == word.length()) {
            return true;
        }
        if (!isInBoard(visited, i, j, board.length, board[0].length)) {
            return false;
        }
        if (word.charAt(wordIdx) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = search(board, visited, word, i + 1, j, wordIdx + 1) ||
        search(board, visited, word, i - 1, j, wordIdx + 1) ||
        search(board, visited, word, i, j + 1, wordIdx + 1) ||
        search(board, visited, word, i, j - 1, wordIdx + 1);
        visited[i][j] = false;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(search(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    void main() {
        char[][] board = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'e', 's'},
                {'a', 'd', 'e', 'e'}
        };
        String word = new String("abceseeefs");
        boolean x = exist(board, word);
    }
}
