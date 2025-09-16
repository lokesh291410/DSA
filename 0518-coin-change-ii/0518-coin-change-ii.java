class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);

        return ways(coins.length - 1, amount, coins, dp);
    }

    public int ways(int idx, int target, int[] nums, int[][] dp) {
        if(target == 0) return 1;
        if(idx == 0) {
            if(target % nums[idx] == 0) return 1;
            else return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = ways(idx - 1, target, nums, dp);
        int take = 0;
        if(target >= nums[idx]) take = ways(idx, target - nums[idx], nums, dp);

        dp[idx][target] = notTake + take;

        return dp[idx][target];
    }
}