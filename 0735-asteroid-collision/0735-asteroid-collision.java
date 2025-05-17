class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[n];

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && asteroids[i] > 0 && 
            Math.abs(asteroids[st.peek()]) <= asteroids[i]) {
                int idx = st.peek();
                st.pop();
                arr[idx] = -1;
                int stVal = asteroids[idx];
                if(Math.abs(stVal) == asteroids[i]) {
                    arr[i] = -1;
                    break;
                }
            }

            if(asteroids[i] < 0) st.push(i);
            else {
                arr[i] = st.isEmpty() && (arr[i] != -1) ? 0 : -1;
            }
        }
        int l = 0;
        for(int i : arr) {
            if(i == 0) l++;
        }

        int[] ans = new int[l];
        int id = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                ans[id] = asteroids[i];
                id++;
            }
        }

        return ans;
    }
}