class Solution {
    public String palindrome(String s, int left, int right) {
        while((left>=0 && right<s.length()) && (s.charAt(left)==s.charAt(right))) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
    public String longestPalindrome(String s) {
        StringBuilder ans = new StringBuilder();
        String currS;
        int max = 0, curr;

        for(int i=0; i<s.length(); i++) {
            currS = palindrome(s, i, i);
            curr = currS.length();

            if(curr > max) {
                ans = new StringBuilder(currS);
                max = curr;
            }

            currS = palindrome(s, i, i+1);
            curr = currS.length();

            if(curr > max) {
                ans = new StringBuilder(currS);
                max = curr;
            }
        }

        return ans.toString();
    }
}