import java.util.*;

// undirected graph

class Solution1{
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
        if(!vis[i]){
        if(bfs(V,i,adj,vis)) return true;
        }
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

// directed graph

class Solution2{
    boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(V,i,-1,vis,adj)) return true;
            }
        }
        return false;
    }

    boolean dfs(int V,int src,int parent,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;

        for(int neighbour : adj.get(src)){
            if(!vis[neighbour]){
                if(dfs(V,neighbour,src,vis,adj)) return true;
            }
            else if(parent!=neighbour) return true;
        }
        return false;
    }
}