class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return n;

        int prevStep = 1;
        int prevStep2 = 1;
        for(int i=2; i<=n; i++) {
            int curr = prevStep + prevStep2;
            prevStep2 = prevStep;
            prevStep = curr;
        }

        return prevStep;
    }
}