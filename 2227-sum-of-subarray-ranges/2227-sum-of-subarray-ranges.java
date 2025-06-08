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

    public int[] nextGreaterElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            
            nge[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return nge;
    }

    public int[] prevGreaterElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pge = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) st.pop();
            
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }

    public long subArrayRanges(int[] nums) {
        int[] nse = nextSmallerElement(nums);
        int[] pse = prevSmallerElement(nums);
        int[] nge = nextGreaterElement(nums);
        int[] pge = prevGreaterElement(nums);
        long ans1 = 0, ans2 = 0;

        for(int i=0; i<nums.length; i++) {
            int ls = i - pse[i];
            int rs = nse[i] - i;
            int lg = i - pge[i];
            int rg = nge[i] - i;

            ans1 = ans1 + (ls * rs * 1L * nums[i]);
            ans2 = ans2 + (lg * rg * 1L * nums[i]);
        }

        return ans2 - ans1;
    }
}