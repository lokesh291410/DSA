class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        for(int num : nums) {
            if(num == 1) {
                count++;
            }else{
                maxpq.add(count);
                count = 0;
            }
        }
        maxpq.add(count);

        return maxpq.peek();    
    }
}