class Solution {

    public void dfs(int open, int close, int n, String str, List<String> ans) {
        if(open == close && open + close == 2 * n) {
            ans.add(str);
            return;
        }

        if(open < n) dfs(open + 1, close, n, str + "(", ans);
        if(close < open) dfs(open, close + 1, n, str + ")", ans);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0, 0, n, "", ans);

        return ans;
    }
}