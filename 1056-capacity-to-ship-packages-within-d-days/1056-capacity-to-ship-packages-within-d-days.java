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

    public int shipWithinDays(int[] weights, int days) {
        int left = max(weights), right = sum(weights);
        int mid = 0, ans = 0;
        while(left <= right) {
            mid = left + (right - left)/2;
            boolean possible = possible(weights, mid, days);
            if(possible) {
                ans = mid;
                right = mid - 1;
            }else left = mid + 1;
        }
        return ans;
    }
}