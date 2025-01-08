class Solution {
    public int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }

    public int sum(int[] arr) {
        int sum = 0; 
        for(int i : arr) {
            sum += i;
        }
        return sum;
    }

    public boolean possible(int[] arr, int cap, int days) {
        int totalDays = 0;
        int weight = 0;
        for(int i : arr) {
            weight += i;
            if(weight > cap) {
                totalDays += 1;
                weight = i;
            }
        }
        if(weight <= cap) totalDays += 1;
        if(totalDays <= days) return true;
        return false;
    }

    public int splitArray(int[] nums, int k) {
        int left = max(nums), right = sum(nums);
        int mid = 0, ans = 0;
        while(left <= right) {
            mid = left + (right - left)/2;
            boolean possible = possible(nums, mid, k);
            if(possible) {
                ans = mid;
                right = mid - 1;
            }else left = mid + 1;
        }
        return ans;
    }
}