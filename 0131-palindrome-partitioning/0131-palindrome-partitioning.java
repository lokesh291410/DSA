class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        findPart(0, s, ans, new ArrayList<>());

        return ans;
    }

    public void findPart(int idx, String s, List<List<String>> ans, List<String> part) {
        if(idx == s.length()) {
            ans.add(new ArrayList<>(part));
            return;
        }

        for(int i=idx; i<s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                part.add(s.substring(idx, i+1));
                findPart(i+1, s, ans, part);
                part.remove(part.size() - 1);
            }
        }
    } 

    public boolean isPalindrome(String s, int st, int end) {
        while(st < end) {
            if(s.charAt(st++) != s.charAt(end--)) return false;
        }

        return true;
    }
}