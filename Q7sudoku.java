// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
/*
Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/


// Insane but time complexity isn't high at all


import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check for symbols
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentChar = board[i][j];
                if (!(Character.isDigit(currentChar) || currentChar == '.')) {
                    return false;
                }
            }
        }

        // Rows
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }

        // Columns
        int j = 0;
        while (j < 9) {
            HashSet<Character> set = new HashSet<>(); // Initialize set for each column
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
            j++;
        }

        // Sub-boxes
        for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 3; blockCol++) {
                HashSet<Character> set = new HashSet<>();
                for (int i = blockRow * 3; i < (blockRow + 1) * 3; i++) {
                    for (int g = blockCol * 3; g < (blockCol + 1) * 3; g++) {
                        if (board[i][g] == '.') {
                            continue;
                        } else {
                            if (set.contains(board[i][g])) {
                                return false;
                            }
                            set.add(board[i][g]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
