class Solution {
    public int find(int i, int[] nums, int[] dp) {
        if(i>=nums.length) return 0;
        if(dp[i] != -1) return dp[i];

        int rob = nums[i] + find(i+2,nums,dp);
        int dont = find(i+1,nums,dp);

        dp[i] = Math.max(rob, dont);
        return dp[i];
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return find(0, nums, dp);
    }
}