class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length(), l = 0, r = 0, minLen = Integer.MAX_VALUE, si = -1;
        int[] freq = new int[256];
        int cnt = 0;

        for(char ch : t.toCharArray()) freq[ch]++;

        while(r < n) {
            if(freq[s.charAt(r)] > 0) cnt++;
            freq[s.charAt(r)]--;

            while(cnt == m) {
                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    si = l;
                }

                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)] > 0) cnt--;
                l++;
            }
            r++;
        }

        return si == -1 ? "" : s.substring(si, si + minLen);
    }
}