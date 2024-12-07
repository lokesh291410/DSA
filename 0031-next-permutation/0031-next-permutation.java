class Solution {
    public void reverse(int[] nums, int st, int ed) {
        while(st < ed) {
            swap(nums, st, ed);
            st++;
            ed--;
        }
    }

    public void swap(int[] nums, int st, int ed) {
        int temp = nums[st];
        nums[st] = nums[ed];
        nums[ed] = temp;
    }

    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }
        if(idx == -1) reverse(nums, 0, n-1);
        else {
            for(int i=n-1; i>idx; i--) {
                if(nums[i] > nums[idx]) {
                    swap(nums, i, idx);
                    break;
                }
            }
            reverse(nums, idx+1, n-1);
        }
    }
}