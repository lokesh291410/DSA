class Solution {
    public void findCombination(int st,int n, int k, List<List<Integer>> ans, List<Integer> comb) {
        if(st == 10) {
            if(n == 0 && k == 0) ans.add(new ArrayList<>(comb));
            return;
        }

        if(st <= n) {
            comb.add(st);
            findCombination(st+1, n-st, k-1, ans, comb);
            comb.remove(comb.size() - 1);
        }
        findCombination(st+1, n, k, ans, comb);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        findCombination(1, n, k, ans, new ArrayList<>());

        return ans;
    }
}