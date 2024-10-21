class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            if(i<k) {
                minpq.add(nums[i]);
            }else if(nums[i] > minpq.peek()) {
                minpq.poll();
                minpq.add(nums[i]);
            }
        }

        return minpq.peek();
    }
}