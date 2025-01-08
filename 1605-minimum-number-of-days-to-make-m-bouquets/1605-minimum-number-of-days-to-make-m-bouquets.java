class Solution {
    public int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i : arr) {
            min = Math.min(i, min);
        }
        return min;
    }

    public int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }
    public boolean totalFlowers(int[] arr, int days, int m, int k) {
        int ans = 0;
        int noOfB = 0;
        for(int i : arr) {
            if(i <= days) ans++;
            else {
                noOfB += (ans / k);
                ans = 0;
            }
        }
        noOfB += (ans / k);
        return noOfB >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int left = min(bloomDay), right = max(bloomDay);
        int mid = 0;
        int ans = -1;
        while(left <= right) {
            mid = left + (right - left)/2;
            boolean totalFlowers = totalFlowers(bloomDay, mid, m, k);
            if(totalFlowers) {
                ans = mid;
                right = mid-1;
            }else left = mid + 1;
        }
        return ans;
    }
}