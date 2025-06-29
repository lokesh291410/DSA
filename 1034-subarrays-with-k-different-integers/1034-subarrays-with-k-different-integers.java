class Solution {
    public int helper(int[] nums, int k) {
        int l = 0, r = 0, ans = 0, currK = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        while(r < nums.length) {
            if(!freq.containsKey(nums[r])) currK++;
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

            while(currK > k && l < nums.length) {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if(freq.get(nums[l]) == 0) {
                    freq.remove(nums[l]);
                    currK--;
                }
                l++;
            }

            ans += (r - l + 1);
            r++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
}