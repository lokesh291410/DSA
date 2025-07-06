class Solution {
    public void findCombination(int idx, int target, int[] arr, 
        List<List<Integer>> ans, List<Integer> combination) {
            if(idx == arr.length) {
                if(target == 0) ans.add(new ArrayList<>(combination));
                return;
            }

            if(arr[idx] <= target) {
                combination.add(arr[idx]);
                findCombination(idx, target - arr[idx], arr, ans, combination);
                combination.remove(combination.size() - 1);
            }

            findCombination(idx + 1, target, arr, ans, combination);
        }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findCombination(0, target, candidates, ans, new ArrayList<>());

        return ans;
    }
}