class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = (matrix.length * matrix[0].length) - 1;
        int mid = 0;
        while(left <= right) {
            mid = left + (right-left)/2;
            int row = mid/matrix[0].length, col = mid%matrix[0].length;

            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] <= target) left = mid + 1;
            else right = mid - 1;
        }
        
        return false;
    }
}