class Solution {
    public void reverse(int[] nums) {
        int i = 0, j = nums.length-1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i<row; i++) {
            for(int j=i+1; j<col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        } 

        for(int[] nums : matrix) {
            reverse(nums);
        }
    }
}