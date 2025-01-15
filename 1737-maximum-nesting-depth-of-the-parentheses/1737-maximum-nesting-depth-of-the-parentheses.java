class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int curr = 0;

        for(char i : s.toCharArray()) {
            if(i == '(') {
                curr++;
                max = Math.max(max, curr);
            }
            if(i == ')') {
                curr--;
            }
        } 
        return max;
    }
}