class Solution {
    int n;
    int m;
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == word.charAt(0) && find(0, i, j, board, word))
                    return true;
            }
        }

        return false;
    }

    public boolean find(int idx, int i, int j, char[][] board, String word) {
        if(idx == word.length()) return true;
        
        if(i<0 || j<0 || i>=n || j>=m || board[i][j] != word.charAt(idx) || board[i][j] == '$')
            return false;
        
        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] arr : dir) {
            if(find(idx+1, i+arr[0], j+arr[1], board, word)) 
                return true;
        }
        board[i][j] = temp;

        return false;
    }
}