class Solution {
    public String largestOddNumber(String num) {
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for(int i=num.length()-1; i>=0; i--) {
            int ch = num.charAt(i) - '0';
            if(ch % 2 != 0) {
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}