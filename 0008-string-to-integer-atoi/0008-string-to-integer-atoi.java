class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int mul = 1;
        int i = 0;
        int ans = 0;
        int n = s.length();
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            mul = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return mul == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }
        
        return ans * mul;
    }
}