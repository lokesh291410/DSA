class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        int[] arr = new int[3];
        Arrays.fill(arr, -1);

        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
            int lastSeen = Math.min(Math.min(arr[0], arr[1]), arr[2]);
            cnt += (1 + lastSeen);
        }
        return cnt;
    }
}