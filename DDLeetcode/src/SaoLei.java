import java.util.Arrays;

public class SaoLei {

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        Solution2 test = new Solution2();
        test.updateBoard(board, click);

    }

};

class Solution2 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int n = click[0];
        int m = click[1];
        if (n < 0 && n > board.length && m > board[0].length && m < 0) {
            return board;
        }
        if (board[n][m] == 'E') {
            if (getneibor(board, n, m) == '0') {
                pass(board, n, m);
            } else {
                board[n][m] = getneibor(board, n, m);
            }

        } else if (board[n][m] == 'M') {
            board[n][m] = 'X';
        }
        return board;
    }

    public void pass(char[][] board, int n, int m) {
        if (n < 0 || n > board.length-1 || m > board[0].length-1 || m < 0) {
            return;
        }
        if (board[n][m] == 'E') {
            board[n][m] = 'B';
            if (getneibor(board, n, m) == '0') {
                pass(board, n - 1, m - 1);
                pass(board, n - 1, m);
                pass(board, n - 1, m + 1);
                pass(board, n - 1, m);
                pass(board, n, m + 1);
                pass(board, n + 1, m - 1);
                pass(board, n + 1, m);
                pass(board, n + 1, m + 1);
            } else {
                board[n][m] = getneibor(board, n, m);
            }
        }
        return;

    }

    public char getneibor(char[][] board, int n, int m) {
        int sum = 0;
        //左上
        if ((n - 1 >= 0) && (m - 1 >= 0) && board[n - 1][m - 1] == 'M') {
            sum++;
        }

        //上
        if ((n - 1 >= 0) && board[n - 1][m] == 'M') {
            sum++;
        }

        //右上
        if ((n - 1 >= 0) && (m + 1 < board[0].length) && board[n - 1][m + 1] == 'M') {
            sum++;
        }

        //左
        if ((m - 1 >= 0) && board[n][m - 1] == 'M') {
            sum++;
        }

        //右
        if ((m + 1 < board[0].length) && board[n][m + 1] == 'M') {
            sum++;
        }

        //左下
        if ((n + 1 < board.length) && (m - 1 >= 0) && board[n + 1][m - 1] == 'M') {
            sum++;
        }

        //下
        if ((n + 1 < board.length) && board[n + 1][m] == 'M') {
            sum++;
        }

        //右下
        if ((n + 1 < board.length) && (m + 1 < board[0].length) && board[n + 1][m + 1] == 'M') {
            sum++;
        }

        char ans = (char) (sum + '0');
        return ans;
    }


}