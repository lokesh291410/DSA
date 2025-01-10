class Solution {
    public int max(int[][] mat, int n, int m, int mid) {
        int max = Integer.MIN_VALUE;
        int row = 0;
        for(int i=0; i<n; i++) {
            if(mat[i][mid] > max) {
                max = mat[i][mid];
                row = i;
            }
        }

        return row;
    }
    public int[] findPeakGrid(int[][] mat) {
        int[] ans = new int[2];
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1, mid = 0;
        while(low <= high) {
            mid = low + (high-low)/2;
            int row = max(mat, n, m, mid);
            int left = mid-1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid+1 < m ? mat[row][mid+1] : -1;
            if(mat[row][mid] > left && mat[row][mid] > right) {
                ans[0] = row;
                ans[1] = mid;
                return ans;
            }else if(mat[row][mid] < left) high = mid - 1;
            else low = mid + 1;
        }

        return ans;
    }
}