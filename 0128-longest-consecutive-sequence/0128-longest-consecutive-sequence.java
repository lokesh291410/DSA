class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;

        Set<Integer> set = new HashSet<>();
        int longest = 1;

        for(int num : nums) {
            set.add(num);
        }

        for(int val : set) {
            if(!set.contains(val-1)) {
                int count = 1;
                int num = val;
                while(set.contains(num+1)) {
                    count += 1;
                    num += 1;
                }
                longest = Math.max(count, longest);
            }
        }

        return longest;
    }
}