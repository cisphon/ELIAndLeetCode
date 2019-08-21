package LeetCode.Easy;

import java.util.Arrays;

public class AvailableCapturesForRook {
    public static void main(String[] args) {
        char[][] board1 = {
                {'.','.','.','.','.','.','.','.'},
                {'.','p','p','p','p','p','.','.'},
                {'.','p','p','B','p','p','.','.'},
                {'.','p','B','R','B','p','.','.'},
                {'.','p','p','B','p','p','.','.'},
                {'.','p','p','p','p','p','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        };
        System.out.println(numRookCaptures(board1));

        char[][] board2 = {
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        };
        System.out.println(numRookCaptures(board2));
    }

    public static int numRookCaptures(char[][] board)
    {
        int rookRow = -1, rookCol = -1;
        // O(N^2) search for the white rook.
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[r].length; ++c) {
                if (board[r][c] == 'R') { // found the white rook
                    rookRow = r;
                    rookCol = c;
                    break; // exit the search
                }
            }
        }

        int numCaptures = 0;
        // See what can be found north of the white rook.
        for (int r = rookRow, c = rookCol; r >= 0; --r) {
            char value = board[r][c];
            if (value == '.')
                continue;
            else if (value == 'B')
                break;
            else if (value == 'p') { // a valid capture.
                ++numCaptures;
                break;
            }
        }

        // See what can be found south of the white rook.
        for (int r = rookRow, c = rookCol; r < board.length; ++r) {
            char value = board[r][c];
            if (value == '.')
                continue;
            else if (value == 'B')
                break;
            else if (value == 'p') { // a valid capture.
                ++numCaptures;
                break;
            }
        }

        // See what can be found west of the white rook.
        for (int r = rookRow, c = rookCol; c >= 0; --c) {
            char value = board[r][c];
            if (value == '.')
                continue;
            else if (value == 'B')
                break;
            else if (value == 'p') { // a valid capture.
                ++numCaptures;
                break;
            }
        }

        // See what can be found east of the white rook.
        for (int r = rookRow, c = rookCol; c < board[r].length; ++c) {
            char value = board[r][c];
            if (value == '.')
                continue;
            else if (value == 'B')
                break;
            else if (value == 'p') { // a valid capture.
                ++numCaptures;
                break;
            }
        }

        return numCaptures;
    }
}
