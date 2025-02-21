class Solution {
    public double pow(double x, long n) {
        if(n == 0) return 1;
        if(n%2 == 0) {
            return pow(x*x, n/2);
        }else {
            return x * pow(x, n-1);
        }
    }
    public double myPow(double x, int n) {
        return n > 0 ? pow(x, n) : 1/pow(x, -(long)n);
    }
}