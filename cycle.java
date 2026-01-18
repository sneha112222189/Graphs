import java.util.*;
class Solution{
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
    boolean[] vis = new boolean[V];

    for(int i=0;i<V;i++){
        if(bfs(V,i,adj,vis)) return true;
    }
    return false;
}


boolean bfs(int V,int src,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(src,-1));
    vis[src]=true;

    while(!q.isEmpty()){
        Pair p = q.poll();
        int node = p.first;
        int parent = p.second;

        for(int neighbour : adj.get(node)){
            if(!vis[neighbour]){
                vis[neighbour]=true;
                q.add(new Pair(neighbour,node));
            }
            else if(parent != neighbour){
                return true;
            }
        }
    }
    return false;
}
}

