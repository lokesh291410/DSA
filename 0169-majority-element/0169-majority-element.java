class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 0;
        for(int num : nums) {
            if(element == num) {
                count++;
            }else {
                count--;
            }
            if(count == 0) {
                element = num;
                count++;
            }
        }
        count = 0;
        for(int num : nums) {
            if(num == element) count++;
        }
        return element;
    }
}