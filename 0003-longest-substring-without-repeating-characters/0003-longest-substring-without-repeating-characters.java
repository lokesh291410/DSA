class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] visited = new int[256];
        int i = 0, j = 0;
        Arrays.fill(visited, -1);

        while(i < s.length() && j < s.length()) {
            if(visited[s.charAt(j)] != -1) {
                if(visited[s.charAt(j)] >= i) i = visited[s.charAt(j)] + 1;
            }
            ans = Math.max(ans, j - i + 1);
            visited[s.charAt(j)] = j;
            j++;
        }

        return ans;
    }
}