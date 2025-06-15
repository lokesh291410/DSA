class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<nums.length; i++) {
            if(!dq.isEmpty() && dq.getFirst() <= i - k) dq.removeFirst();

            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.removeLast();

            dq.addLast(i);
            if(i >= k-1) list.add(nums[dq.getFirst()]);
        }

        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}