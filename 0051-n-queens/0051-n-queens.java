class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] backRow = new int[n];
        int[] lowerDiag = new int[2 * n - 1];
        int[] upperDiag = new int[2 * n - 1];

        fill(0, backRow, lowerDiag, upperDiag, ans, board, n);

        return ans;
    }

    public void fill(int col, int[] backRow, int[] lowerDiag, int[] upperDiag,
        List<List<String>> ans, char[][] board, int n) {
            if(col == n) {
                ans.add(construct(board));
                return;
            }

            for(int row=0; row<n; row++) {
                if(backRow[row] == 0 && lowerDiag[row + col] == 0 && upperDiag[n-1 + col-row] == 0) {
                    board[row][col] = 'Q';
                    backRow[row] = 1;
                    lowerDiag[row + col] = 1;
                    upperDiag[n-1 + col-row] = 1;

                    fill(col + 1, backRow, lowerDiag, upperDiag, ans, board, n);

                    board[row][col] = '.';
                    backRow[row] = 0;
                    lowerDiag[row + col] = 0;
                    upperDiag[n-1 + col-row] = 0;
                }
            }
        }

        public List<String> construct(char[][] board) {
            List<String> list = new ArrayList<>();
            for(int i=0; i<board.length; i++) {
                String s = new String(board[i]);
                list.add(s);
            }
            
            return list;
        }
}