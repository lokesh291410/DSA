class Solution {
    public int helper(int[] nums, int k) {
        if(k < 0) return 0;

        int l = 0, r = 0, cnt = 0, ans = 0;

        while(r < nums.length) {
            cnt = nums[r] % 2 != 0 ? cnt + 1 : cnt;
            while(cnt > k) {
                cnt = nums[l] % 2 != 0 ? cnt - 1 : cnt;
                l++;
            }
            ans += (r - l + 1);
            r++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
}