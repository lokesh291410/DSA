class Solution {
    public int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }

    public boolean isSum(int[] arr, int div, int th) {
        int sum = 0;
        for(int i : arr) {
            sum += Math.ceil((double)i / (double)div);
        }

        if(sum <= th) return true;
        return false;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = max(nums);
        int mid = 0, ans = 0;
        while(left <= right) {
            mid = left + (right - left)/2;
            boolean isSum = isSum(nums, mid, threshold);
            if(isSum) {
                ans = mid;
                right = mid - 1;
            }else left = mid + 1;
        }
        return ans;
    }
}