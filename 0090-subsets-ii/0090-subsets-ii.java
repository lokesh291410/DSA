class Solution {
    public void findSubsets(int idx, int[] nums, List<List<Integer>> ans, List<Integer> subset) {
        ans.add(new ArrayList<>(subset));

        for(int i=idx; i<nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) continue;

            subset.add(nums[i]);
            findSubsets(i+1, nums, ans, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        findSubsets(0, nums, ans, new ArrayList<>());
        return ans;
    }
}