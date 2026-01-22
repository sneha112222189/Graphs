import java.util.*;
class Solution {
    class Pair{
        int first;
        double second;
        Pair(int first,double second){
            this.first=first;
            this.second=second;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double w=succProb[i];

            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        double[] prob = new double[n];
        Arrays.fill(prob,0.0);
        prob[start_node]=1;
        boolean[] fin = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.second,a.second));
        pq.add(new Pair(start_node,prob[start_node]));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.first;

            if(fin[node]) continue;
            fin[node]=true;

            for(Pair nei : adj.get(node)){
                int v = nei.first;
                double w=nei.second;
                if(!fin[v] &&  prob[node] * w > prob[v]){
                    prob[v]=prob[node] * w;
                    pq.add(new Pair(v,prob[v]));
                }
            }
        }

        return prob[end_node];
    }
}
