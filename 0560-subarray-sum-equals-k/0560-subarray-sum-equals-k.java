class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0, cnt = 0;

        for(int num : nums) {
            preSum += num;
            int rem = preSum-k;
            cnt += map.getOrDefault(rem,0);
            map.put(preSum, map.getOrDefault(preSum,0)+1);
        }

        return cnt;
    }
}