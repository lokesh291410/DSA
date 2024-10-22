class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] positiveArr = new int[nums.length/2];
        int[] negativeArr = new int[nums.length/2];
        int[] ans = new int[nums.length];
        int i = 0, j = 0;
        for(int num : nums) {
            if(num > 0) {
                positiveArr[i] = num;
                i++;
            } 
            if(num < 0) {
                negativeArr[j] = num;
                j++;
            }
        }
        int x = 0;
        for(int p=0; p<nums.length-1; p+=2) {
            ans[p] = positiveArr[x];
            ans[p+1] = negativeArr[x];
            x++;
        }
        return ans;
    }
}