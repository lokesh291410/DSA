class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;

        if(sum % 2 != 0) return false;

        int[][] dp = new int[nums.length][(sum/2) + 1];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);

        return can(nums.length-1, sum/2, nums, dp);
    }

    public boolean can(int idx, int target, int[] nums, int[][] dp) {
        if(target == 0) return true;
        if(idx == 0) return nums[idx] == target;

        if(dp[idx][target] != -1) return dp[idx][target] == 1 ? true : false;

        boolean notTake = can(idx - 1, target, nums, dp);
        boolean take = false;
        if(target >= nums[idx]) take = can(idx - 1, target - nums[idx], nums, dp);
        
        dp[idx][target] = take || notTake ? 1 : 0;

        return dp[idx][target] == 1 ? true : false; 
    }
}