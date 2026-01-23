import java.util.*;

class Solution {
    public void findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            //ans = Math.min(ans,bfs(adj,vis,i));
        }
    }

    void bfs(List<List<Integer>> adj,boolean[] vis,int start){
        int[] parent= new int[vis.length];
        Arrays.fill(parent,-1);
        vis[start]=true;

        for(int nei : adj.get(start)){
            if(parent[nei]==-1){
                vis[nei]=true;
                parent[nei] = 1;
                bfs(adj,vis,start);
            }
            else if(parent[nei] != start);
        }
    }
}
