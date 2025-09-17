class Solution {
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);

        return find(s1.length()-1, s2.length()-1, s1, s2, dp);
    }

    public int find(int i, int j, String s1, String s2, int[][] dp) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = find(i - 1, j - 1, s1, s2, dp);
            return dp[i][j];
        }

        dp[i][j] = Math.min(
            Math.min(
                1 + find(i, j - 1, s1, s2, dp),
                1 + find(i - 1, j, s1, s2, dp)
            ),
            1 + find(i - 1, j - 1, s1, s2, dp)
        );

        return dp[i][j]; 
    }
}