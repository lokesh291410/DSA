class Solution {
    public void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;

        for(int num : nums) {
            if(num == 0) countZero++;
            if(num == 1) countOne++;
            if(num == 2) countTwo++;
        }

        int i=0;
        for(; i<countZero; i++) {
            nums[i] = 0;
        }
        int j = i+countOne;
        for(; i<j; i++) {
            nums[i] = 1;
        }
        int k = i+countTwo;
        for(; i<k; i++) {
            nums[i] = 2;
        }
    }
}