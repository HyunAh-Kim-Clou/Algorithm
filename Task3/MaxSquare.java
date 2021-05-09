public class MaxSquare {
    int ORANGE = 1;
    int[][] board;
    int m, n;

    MaxSquare(int[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
    }

    Boolean canBig(int i, int j) {
        if (board[i+1][j] == ORANGE && board[i][j+1] == ORANGE)
            return true;
        return false;
    }

    int getMaxSquare() {
        int max = 1;
        for (int i = 0; i < m-1; i++)
            for (int j = 0; j < n-1; j++) {
                int tmp = 1;
                if (board[i][j] == ORANGE)
                    while (canBig(i, j)) {
                        tmp++;
                        i++;
                        j++;
                    }
                if (tmp > max)
                    max = tmp;
            }
        return max;
    }
}
