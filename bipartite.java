import java.util.*;

class bipartite {
    public void bipartite(int V,List<List<Integer>> adj){
        int[]color = new int[V];
        for(int i : color){
            color[i]=-1;
        }

        for(int i=0;i<V;i++){
            if(color[i] == -1){
                bfs(adj,color,i);
            }
        }
    }

    boolean bfs(List<List<Integer>> adj,int[] color,int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i]=0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbour : adj.get(node)){
                if(color[neighbour] == -1){
                    color[neighbour] = 1-color[node];
                    q.add(neighbour);
                }
                else if(color[neighbour] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
