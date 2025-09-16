class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);

        int ans = coins(coins.length - 1, amount, coins, dp);

        return ans >= (int)1e9 ? -1 : ans;
    }

    public int coins(int idx, int target, int[] nums, int[][] dp) {
        if(idx == 0) {
            if(target % nums[idx] == 0) return target / nums[idx];
            else return (int)1e9;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = coins(idx - 1, target, nums, dp);
        int take = Integer.MAX_VALUE;
        if(target >= nums[idx]) take = 1 + coins(idx, target - nums[idx], nums, dp);

        dp[idx][target] = Math.min(take, notTake);

        return dp[idx][target];
    }
}