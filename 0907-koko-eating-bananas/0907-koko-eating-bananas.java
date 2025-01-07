class Solution {
    public int totalTime(int[] arr, int k) {
        int totalTime = 0;
        for(int i : arr) {
            totalTime += Math.ceil((double)i / (double)k);
        }
        return totalTime;
    }

    public int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0, right = max(piles);
        int ans = 0;
        int mid = 0;
        while(left <= right) {
            mid = left + (right - left)/2;
            int totalTime = totalTime(piles, mid);
            if(totalTime <= h) {
                ans = mid;
                right = mid - 1;
            }else left = mid + 1;
        }
        return ans;
    }
}