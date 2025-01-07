class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        int mid = 0;
        while(left < right) {
            mid = left + (right-left)/2;
            if(mid%2 == 0) {
                if(nums[mid] == nums[mid+1]) left = mid + 2;
                else right = mid;
            }else {
                if(nums[mid] == nums[mid-1]) left = mid+1;
                else right = mid;
            }
        }
        return nums[left];
    }
}