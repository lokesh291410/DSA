class Solution {
    public void bfs(int i, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;

        while(!q.isEmpty()) {
            Integer node = q.poll();

            for(Integer it : adj.get(node)) {
                if(vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<v; i++) {
            for(int j=0; j<v; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[v];
        int ans = 0;

        for(int i=0; i<v; i++) {
            if(vis[i] == false) {
                bfs(i, adj, vis);
                ans += 1;
            }
        }

        return ans;
    }
}