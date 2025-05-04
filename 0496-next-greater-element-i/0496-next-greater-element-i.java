class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n1 = nums1.length, n2 = nums2.length;

        for(int i=n2-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();

            if(st.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }

        int[] ans = new int[n1];
        for(int i=0; i<n1; i++) {
            ans[i] = map.getOrDefault(nums1[i],-1);
        }

        return ans;
    }
}