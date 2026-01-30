import java.util.*;
import java.io.*;

public class dijkstraCF {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        int start = 1;
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;

        int[] parent = new int[n+1];
        Arrays.fill(parent,-1);


        boolean[] isFin = new boolean[n+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.second,b.second));
        pq.add(new Pair(start,dist[start]));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.first;

            if(isFin[node]) continue;
            isFin[node]=true;

            for(Pair nei : adj.get(node)){
                int e = nei.first;
                int w = nei.second;
                 
                if(!isFin[e] && dist[e]>dist[node]+w){
                    dist[e]=dist[node]+w;
                    parent[e]=node;
                    pq.add(new Pair(e,dist[e]));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(dist[n]==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        int curr=n;
        while(curr!=-1){
        ans.add(curr);
        curr=parent[curr];
        }
        Collections.reverse(ans);
        for(int x:ans){
            System.out.print(x+" ");
        }
    }
}

