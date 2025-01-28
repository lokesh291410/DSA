class Solution {
    public boolean xorGame(int[] nums) {
        int n=nums.length;
        int xorSum=0;
        for(int num:nums){
            xorSum^=num;
        }
        return xorSum==0 || n%2==0;

        
    }
}