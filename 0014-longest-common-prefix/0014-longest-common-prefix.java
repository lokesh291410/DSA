class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder(strs[0]);
        int i = 0;
        while(i < strs.length) {
            if(strs[i].startsWith(ans.toString())) {
                i++;
            }else {
                ans.deleteCharAt(ans.length() - 1);
            }
            if(ans.toString().isEmpty()) {
                break;
            }
        }
        return ans.toString();
    }
}