package com.fasp;

public class WordSearch {
    private final char[][] grid;

    public WordSearch(char[][] grid) {
        this.grid = grid;
    }

    public int[] find(String word) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (foundUpward(row, col, word) || foundRight(row, col, word) || foundDownward(row, col, word) || foundLeft(row, col, word)
                        || foundUpwardRight(row, col, word) || foundDownwardRight(row, col, word) || foundDownwardLeft(row, col, word) || foundUpwardLeft(row, col, word)) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean foundUpward(int row, int col, String word) {
        if (row - word.length() < -1) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (grid[row - i][col] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean foundRight(int row, int col, String word) {
        throw new UnsupportedOperationException("muss programmiert werden");
    }

    private boolean foundDownward(int row, int col, String word) {
        throw new UnsupportedOperationException("muss programmiert werden");
    }

    private boolean foundLeft(int row, int col, String word) {
        throw new UnsupportedOperationException("muss programmiert werden");
    }

    private boolean foundUpwardRight(int row, int col, String word) {
        throw new UnsupportedOperationException("muss programmiert werden");
    }

    private boolean foundDownwardRight(int row, int col, String word) {
        throw new UnsupportedOperationException("muss programmiert werden");
    }

    private boolean foundDownwardLeft(int row, int col, String word) {
        throw new UnsupportedOperationException("muss programmiert werden");
    }

    private boolean foundUpwardLeft(int row, int col, String word) {
        throw new UnsupportedOperationException("muss programmiert werden");
    }
}
