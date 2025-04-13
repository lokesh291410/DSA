class Solution {
    class Pair {
        int row;
        int col;
        int tm;

        Pair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }else vis[i][j] = 0;
                if(grid[i][j] == 1) cntFresh += 1;
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int cnt = 0;
        int tm = 0;
        while(!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            q.remove();
            tm = Math.max(tm, t);

            for(int i=0; i<4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                    vis[nrow][ncol]==0 && grid[nrow][ncol]==1) {
                        q.add(new Pair(nrow, ncol, t+1));
                        vis[nrow][ncol] = 2;
                        cnt += 1;
                }
            }
        }

        if(cntFresh != cnt) return -1;
        return tm;
    }
}