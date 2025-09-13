class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        int n = prerequisites.length;
        for(int i=0; i<n; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }

        int[] topo = topoSort(V, adj); 

        return topo;
    }

    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] inDeg = new int[V];
        for(int i=0; i<V; i++) {
            for(int n : adj.get(i)) {
                inDeg[n]++;
            }
        }

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++) {
            if(inDeg[i] == 0) st.push(i); 
        }

        int[] topo = new int[V];
        int cnt = 0;
        int i = 0;
        while(!st.isEmpty()) {
            int node = st.pop();
            cnt++;
            topo[i++] = node;
            for(int n : adj.get(node)) {
                inDeg[n]--;
                if(inDeg[n] == 0) st.push(n);
            }
        }

        return cnt == V ? topo : new int[]{};
    }
}