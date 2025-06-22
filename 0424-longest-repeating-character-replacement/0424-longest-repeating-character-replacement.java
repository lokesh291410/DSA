class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxFreq = 0, maxLen = 0;
        int[] freq = new int[26];

        while(r < s.length()) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

            if((r - l + 1) - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            if((r - l + 1) - maxFreq <= k) maxLen = Math.max(maxLen, (r - l + 1));
            r++; 
        }
        return maxLen;
    }
}