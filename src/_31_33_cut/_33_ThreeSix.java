package _31_33_cut;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
public class _33_ThreeSix {
    public boolean isValidSudoku(char[][] board) {
        boolean [][] row = new boolean [board.length][board.length];
        boolean [][] col= new boolean [board.length][board.length];
        boolean [][] box = new boolean [board.length][board.length];
        for (int i = 0;i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!='.') {
                    int num = board[i][j]-'0'-1;
                    int k = i/3*3+j/3;
                    if (row[i][num]||col[j][num]||box[k][num]) {
                        return false;
                    }
                    row[i][num]=col[j][num]=box[k][num]=true;
                }
            }
        }
        return true;
    }
}
