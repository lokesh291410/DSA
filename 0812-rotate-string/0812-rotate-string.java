class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String str = s+s;
        return str.indexOf(goal) >= 0 ? true : false;
        }
}