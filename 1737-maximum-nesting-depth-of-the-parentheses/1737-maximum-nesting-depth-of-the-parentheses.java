class Solution {
    public int maxDepth(String s) {
        int max = 0;
        Stack<Character> valid = new Stack<>();

        for(char i : s.toCharArray()) {
            if(i == '(') {
                valid.push(i);
                max = Math.max(max, valid.size());
            }
            if(i == ')') {
                valid.pop();
            }
        } 
        return max;
    }
}