class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        int n = prerequisites.length;
        for(int i=0; i<n; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
        }

        int topo = topoSort(V, adj);

        if(topo == V) return true;
        
        return false;
    }   

    public int topoSort(int V, List<List<Integer>> adj) {
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

        int topo = 0;
        int i = 0;
        while(!st.isEmpty()) {
            int node = st.pop();
            topo++;
            for(int n : adj.get(node)) {
                inDeg[n]--;
                if(inDeg[n] == 0) st.push(n);
            }
        }

        return topo;
    }
}