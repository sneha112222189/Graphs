import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
         
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);           
            adj.get(v).add(u);
        }

        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                Queue<Integer> q = new LinkedList<>();
                ArrayList<Integer> component = new ArrayList<>();

                vis[i]=true;
                q.add(i);
                
                while(!q.isEmpty()){
                    int node = q.poll();
                    component.add(node);
                    for(int neighbour : adj.get(node)){
                        if(!vis[neighbour]){
                            vis[neighbour]=true;
                            q.add(neighbour);
                        }
                    }
                }
                l.add(component);
            }
        }
        return l;
        
    }
}