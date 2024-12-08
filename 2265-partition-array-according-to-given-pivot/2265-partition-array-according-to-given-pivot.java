class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int idx = 0;
        int[] ans = new int[nums.length];

        for(int num : nums) {
            if(num < pivot) {
                ans[idx] = num;
                idx++;
            }
        }

        for(int num : nums) {
            if(num == pivot) {
                ans[idx] = num;
                idx++;
            }
        }

        for(int num : nums) {
            if(num > pivot) {
                ans[idx] = num;
                idx++;
            }
        }
        
        return ans;
    }
}