class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);

        return length(0, -1, nums, dp);
    }

    public int length(int idx, int prev, int[] nums, int[][] dp) {
        if(idx == nums.length) return 0;

        if(dp[idx][prev + 1] != -1) return dp[idx][prev + 1];

        int notTake = length(idx + 1, prev, nums, dp);
        int take = Integer.MIN_VALUE;
        if(prev == -1 || nums[idx] > nums[prev])
            take = 1 + length(idx + 1, idx, nums, dp);
        
        dp[idx][prev + 1] = Math.max(notTake, take);
        
        return dp[idx][prev + 1];
    }
}