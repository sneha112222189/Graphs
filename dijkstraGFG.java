import java.util.*;

class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        boolean[] isFin = new boolean[V];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.second,b.second));
        pq.add(new Pair(src,dist[src]));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int e = p.first;
            
            
            if(isFin[e]) continue;
            isFin[e]=true;
            
            for(Pair nei : adj.get(e)){
                int e1 = nei.first;
                int w = nei.second;
                
                
                if(!isFin[e1] && dist[e1]>dist[e]+w){
                    dist[e1]=dist[e]+w;
                    pq.add(new Pair(e1,dist[e1]));
                }
            }
        }
        return dist;
       
    }
}
