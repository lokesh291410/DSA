class Solution {
    int cnt = 0;
    public int totalNQueens(int n) {
        int[] backRow = new int[n];
        int[] lowerDiag = new int[2 * n - 1];
        int[] upperDiag = new int[2 * n - 1];

        fill(0, backRow, lowerDiag, upperDiag, n);

        return cnt;
    }

    public void fill(int col, int[] backRow, int[] lowerDiag, int[] upperDiag, int n) {
            if(col == n) {
                cnt++;
                return;
            }

            for(int row=0; row<n; row++) {
                if(backRow[row] == 0 && lowerDiag[row + col] == 0 && upperDiag[n-1 + col-row] == 0) {
                    backRow[row] = 1;
                    lowerDiag[row + col] = 1;
                    upperDiag[n-1 + col-row] = 1;

                    fill(col + 1, backRow, lowerDiag, upperDiag, n);

                    backRow[row] = 0;
                    lowerDiag[row + col] = 0;
                    upperDiag[n-1 + col-row] = 0;
                }
            }
        }
}