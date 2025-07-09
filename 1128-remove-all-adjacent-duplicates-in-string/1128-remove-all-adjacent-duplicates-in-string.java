class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        boolean repeat = false;
        for(char ch : s.toCharArray()) {
            repeat = false;
            while(!st.isEmpty() && ch == st.peek()) {
                st.pop();
                repeat = true;
            }
            if(!repeat) st.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();

        return sb.toString();
    }
}