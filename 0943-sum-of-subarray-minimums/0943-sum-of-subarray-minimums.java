class Solution {
    public int[] nextSmallerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            
            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] prevSmallerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] nse = nextSmallerElement(arr);
        int[] pse = prevSmallerElement(arr);
        int ans = 0, mod = (int)(Math.pow(10, 9) + 7);

        for(int i=0; i<arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            ans = (int)(ans + (left * right * 1L * arr[i]) % mod) % mod;
        }

        return ans;
    }
}