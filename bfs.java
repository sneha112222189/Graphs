import java.util.*;

class Graph {
    int V;
    ArrayList<ArrayList<Integer>> adj;

    Graph(int V){
        this.V=V;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    void bfs(int start){
        boolean[] visited=new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        visited[start]=true;
        q.add(start);

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.println(node+" , ");

            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.add(neighbour);
                }
            }
        }
    }
    
    
}
